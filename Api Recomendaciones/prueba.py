from flask import Flask, jsonify, request
import pandas as pd
import requests
import json
import pickle
import statsmodels.api as sm
import openai
import re
from unicodedata import normalize

def obtenerOperacionesPandas(idUsuario):

    response = requests.get('http://localhost:8080/ux-operaciones/appww/servicio-al-cliente/v1/listar-gastos?idUsuario='
                           +str(idUsuario))
    
    if response.status_code == 200:
        data = pd.read_json(json.dumps(response.json()))
    elif response.status_code == 400:
        print('ID invalido')
    elif response.status_code == 404:
        print('Recomendación no encontrada')
    elif response.status_code == 405:
        print('Ingreso invalido')
    
    return  data

def obtenerPresupuesto(idUsuario):
    
    response = requests.get('http://localhost:8080/ux-presupuesto/appww/servicio-al-cliente/v1/obtener-presupuesto?idUsuario='
                            +str(idUsuario))
    
    if response.status_code == 200:
        data = pd.read_json(json.dumps(response.json()))
    elif response.status_code == 400:
        print('ID invalido')
    elif response.status_code == 404:
        print('Presupuesto not found')
    elif response.status_code == 405:
        print('Validation exception')
        
    data['fechaInicio'] = data['fechaInicio'].str.slice(0, 10)
    data['fechaFin'] = data['fechaFin'].str.slice(0, 10)
    data['fechaInicio'] = pd.to_datetime(data['fechaInicio'])
    data['fechaFin'] = pd.to_datetime(data['fechaFin'])

    return  data
    
    

def procesarDatos(data):
    prueba = data[['fechaReal','monto','nombre']]
    prueba['fechaReal'] = prueba['fechaReal'].str.slice(0, 10)
    monto_sum = prueba.groupby('fechaReal')['monto'].sum().reset_index()
    nombre_concat = prueba.groupby('fechaReal')['nombre'].apply(lambda x: ','.join(map(str, x))).reset_index()
    prueba = monto_sum.merge(nombre_concat, on='fechaReal')
    prueba['fechaReal'] = pd.to_datetime(prueba['fechaReal'])
    prueba = prueba.sort_values(by='fechaReal')
    prueba = prueba.set_index('fechaReal')
    prueba = pd.DataFrame(prueba, index=prueba.index, columns=['monto','nombre'])
    prueba = prueba.asfreq('D')
    prueba['monto'] = prueba['monto'].fillna(0)
    prueba = prueba.iloc[-40:]
    return prueba


def modeloSarimax(presupuesto, data):
    temp_pre = presupuesto[['fechaInicio','fechaFin']]
    temp_pre['fechaInicio'] = pd.to_datetime(temp_pre['fechaInicio'])
    temp_pre['fechaFin'] = pd.to_datetime(temp_pre['fechaFin'])
    predictions = loaded_model.predict(start=temp_pre['fechaInicio'][0], 
                             end=temp_pre['fechaFin'][0])
    predictions = (predictions > 0).astype(int)*predictions
    
    return predictions

def obtenerPrompt(presupuesto, data, predictions, nombre):
    presupuesto = presupuesto.head(1).set_index('fechaInicio')
    presupuesto = pd.DataFrame(presupuesto, index=presupuesto.index, columns=['monto','nombre'])
    presupuesto = presupuesto.asfreq('D')
    data = data[data.index>=presupuesto.index[0]]
    prompt = ("\nEres un asesor financiero que da respuestas cortas y sencillas, das recomendaciones en base a los gastos y los nombres de los gastos utilizando un modelo de forecasting que predice los gastos de las personas para un presupuesto dado."
                +"\nTu personalidad y/o comportamiento:"
                +"\n- Actuar de forma amigable"
                +"\n- Reducir al minimo el numero de palabras que utilizas en tus recomendacinoes"
                +"\n- Aludir al pronóstico del modelo como si fuera algo que tu mismo calculaste"
                +"\n- No saltarte ningún dato importante como los gastos hasta el dia de hoy"
                +"\n- Las monedas estan en soles"
                +"\nLa persona a la que asesores se llama "+nombre+"."
                +"\nDescripción de la tabla:"
                +"\n- Fecha: indica la fecha"
                +"\n- Gasto Real: indica el gasto real del usuario en la fecha dada"
                +"\n- Gasto Modelo: Es lo que predice que gastará el modelo de forecasting"
                +"\n- Monto Real: Es el dinero que le queda al usuario según el presupuesto asignado"
                +"\n- Monto Modelo: Es el monto que le queda al usuario siguiendo la predicción del modelo"
                +"\n- Descripción de gasto: Es la descripción del gasto real del usuario"
                +"\nLa fecha de hoy es "+str(data.index.values[-1])[0:10]+", se tiene un presupuesto de "+str(presupuesto['monto'].values[0])+", a continuación se muestra la tabla del progreso de los gatos según el modelo y los gastos reales hasta la fecha:"
             )
    prompt = prompt + "\n|Fecha|Gasto Real|Gasto Modelo|Monto Real|Monto Modelo|Descripcion de Gasto|"
    presReal, presModelo = [presupuesto['monto'].values[0]],[presupuesto['monto'].values[0]]

    for i in range(predictions.shape[0]):
        monto = 0
        nombre = "nan"
        if i==data['monto'].values.shape[0]:
            prompt = prompt + "\n FECHA LIMITE (HOY) A PARTIR DE ESTA FILA SE PRESENTAN LOS GASTOS FUTUROS"
            pronosTempHoy = str(int(presModelo[-1]))
        elif data['monto'].values.shape[0]>=i+1:
            monto = data['monto'].values[i]
            nombre = str(data['nombre'].values[i])+'|'

        presReal.append(presReal[i]-monto)
        presModelo.append(presModelo[i]-predictions.values[i])
        aux = ("\n |"
            + str(predictions.index[i])[:10]
            +'|'+str(monto)
            +'|'+str(predictions.values[i])
            +'|'+str(presReal[i+1])
            +'|'+str(presModelo[i+1])
            +'|'+str(nombre))+'|'
        prompt = prompt + aux

    prompt = prompt + ("\nNota: recuerda que la fecha de hoy es"+str(data.index.values[-1])[0:10]+", por lo que de ese día en adelante no debes considerar para nada a los gastos y montos reales, pues aun no suceden, ignora a los gastos tipo nan, pues estos sugieren que no hubo un registro."
                    + "\nRecuerda que debes dar una recomendación corta, no mas de un párrafo siendo consiso en que tipo de gasto debo disminuir o si estoy llendo por buen camino para cumplir con mi presupuesto"
                    + "\nInformacion que debes proporcionar:"
                    + "\n- Como estan sus gastos al dia de hoy"
                    + "\n- Tipos de gastos que debe de disminuir si los gastos pronosticados son mayores al presupuesto (indispensable, gastos  de tercera necesidad y mencionar gastos específicos)"
                    + "\n- En caso de que los gastos pronosticados no superen el presupuesto, dale un seguimiento de lo  que va gastando al día de hoy, si supera por mucho o no supera o simplemente son parecido a los gastos pronosticados"
                    + "\nDatos:"
                    + "\nGastos hasta el dia de hoy: "+str(int(presReal[-1]))
                    + "\nPronosticado hasta el dia de hoy: "+pronosTempHoy
                    + "\nPronostico supera presupuesto: "+str(presModelo[-1]<0)
                    + "\nPronostico presupuesto final: "+str(presModelo[-1])
                    + "\nPresupuesto: "+str(presupuesto['monto'].values[0])
                    + "\nFromato:"
                    + "\nHola [usuario], soy WealthBot ....")
    
    return prompt, presReal, presModelo

def obtenerRecomendacion(prompt):
    openai.api_key = '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'

    response = openai.ChatCompletion.create(
      model="gpt-3.5-turbo",
      messages=[
            {"role": "system", "content": prompt}
        ]
    )

    response_content = response.choices[0].message.content
    return response_content

def obtenerJson(recomendacion, real, pronostico):
    response = {
        'real':real[1:],
        'recomendacion': recomendacion,
        'pronostico' : pronostico[1:]
    }
    return response

def quitarSimbolos(cadena):

    cadena = re.sub(
            r"([^n\u0300-\u036f]|n(?!\u0303(?![\u0300-\u036f])))[\u0300-\u036f]+", r"\1", 
            normalize( "NFD", cadena), 0, re.I
        )

    # -> NFC
    cadena = normalize( 'NFC', cadena)
    
    
    return cadena






config = {
    'user': 'root',
    'password': '',
    'port':3306,
    'host': 'localhost',
    'database': 'wealthworkbd'
}

app = Flask(__name__)

@app.route('/ux-recomendaciones/appww/servicio-al-cliente/v1/obtener-recomendacion', methods=['GET'])
def obtener_datos_negocio():
    # Lógica para obtener los datos del negocio
    # idPresupuesto = request.args.get('idUsuario')
    idUsuario = request.args.get('idUsuario')
    print(idUsuario)
    print(type(idUsuario))
    #obtener presupuesto
    presupuesto = obtenerPresupuesto(idUsuario)
    
    print(presupuesto.dtypes)
    
    data = obtenerOperacionesPandas(idUsuario)

    nombre = data['usuario'].values[0]['userName']

    data = procesarDatos(data)

    predictions = modeloSarimax(presupuesto, data)

    prompt, real, pronostico = obtenerPrompt(presupuesto, data, predictions, nombre)

    recomendacion = obtenerRecomendacion(prompt)

    recomendacion = quitarSimbolos(recomendacion)
    
    responseApiRecomendacion = obtenerJson(recomendacion, real, pronostico)
    
    json_response = jsonify(responseApiRecomendacion)
    
    return json_response

if __name__ == '__main__':
    global loaded_model
    with open('modelo_sarimax.pkl', 'rb') as f:
        loaded_model = pickle.load(f)
    
    app.run(host='0.0.0.0', port=5000)

