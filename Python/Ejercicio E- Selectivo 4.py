#Realice un algoritmo para determinar cuánto se debe pagar por una cierta cantidad de lápices considerando que, si son 1000 lápices o más, el costo es de 2 pesos; 
# de lo contrario, el precio es de 2.50 pesos. 

cantlapiz=int(input("Introduzca una cantidad de lapíces "))

if cantlapiz>=1000:
    costo=cantlapiz*2
    print(f"El costo por los {cantlapiz} es de {costo}")
else:
    costo=cantlapiz*2.50
    print(f"El costo por los {cantlapiz} es de {costo}")
    