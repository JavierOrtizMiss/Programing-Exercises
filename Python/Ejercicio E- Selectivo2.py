#Realice un algoritmo para determinar si un número es positivo o negativo. Represéntelo en pseudocódigo y diagrama de flujo

numero=int(input("Ingrese un número: "))

if numero<0:
    print(f"El número {numero} es negativo")
else:
    if numero==0:
        print(f"El número {numero} es neutro")
    else:
        print(f"El numero {numero} es positivo")