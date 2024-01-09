#Faltó el profesor y los alumnos armaron su propia clase

#Pedir el nombre y la edad de los compañeros que vinieron hoy a clase


def obtener_compañeros(cantidad_de_compañeros):
    compañeros=[]
    for i in range (cantidad_de_compañeros):
        nombre=input("Ingrese el nombre del compañero: ")
        edad=int(input("Ingrese la edad del compañero: "))
        compañero=(nombre,edad)
        compañeros.append(compañero)
    compañeros.sort(key=lambda x:x[1])
    asistente= compañeros[0][0]
    profesor= compañeros[-1][0]
    return asistente,profesor

asistente,profesor=obtener_compañeros(5)
print(f"El profesor es: {profesor} y su asistente es {asistente}")
        
    
