#Dado como dato el sueldo de un trabajador, aplíquele un aumento del 15% si su
#sueldo es inferior a $1000. Imprima en este caso el nuevo sueldo del trabajador.
#Haga el diagrama de flujo y pseudocódigo correspondientes.

sueldo=int(input("Escriba el sueldo del trabajador: "))

if sueldo<1000:
    aumento=sueldo*1.15
    print(f"Su sueldo con aumento es de: {aumento}")
else:
    print(f"Su sueldo es {sueldo} y no ha cambiado")