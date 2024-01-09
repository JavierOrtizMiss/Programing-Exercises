#Un restaurant ofrece hamburguesas sencillas, dobles y triples, las cuales tienen un costo de $20.00, $25.00 y $28.00 respectivamente. Laempresa acepta tarjetas de crédito 
# con un cargo de 5 % sobre el total de la compra. Suponiendo que los clientes adquieren sólo un tipo de hamburguesa, realice un algoritmo para determinar cuánto debe pagar 
# una persona por N hamburguesas. Represéntelo mediante diagrama de flujo y pseudocódigo. 

N=int(input("Introduzca el número de hamburguesas que va adquirir: "))

tipo=input("Introduzca el tipo de hamburguesa que desea, sencilla, doble o triple: ")
if tipo not in ["sencilla", "doble", "triple"]:
    print("Por favor, introduzca un tipo valido")
    exit()
    
if tipo=="sencilla":
    cost=N*20
elif tipo == "doble":
    cost=N*25
else:
    cost=N*28

card=input("¿Procede a pagar con tarjeta? y/n") 
           
    
if card=="y":
    cost=cost*1.05
    print(f"El costo de total de {N} hamburguesas es de: {cost}")
elif card=="n":
    print(f"El costo de total de {N} hamburguesas es de: {cost}")
else:
    print("Por favor, seleccione una opción correcta")
    exit()


