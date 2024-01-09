#Pedirle al usuario las ventas
N=int(input("Introduzca el número de ventas durante su día: "))

montotal=0
mayormil=0
montmil=0
menorquin=0
montquin=0
medio=0
medimont=0

for costo_venta in range (1,N+1):
    costo=float(input(f"Introduzca el costo de la venta {costo_venta}"))
    montotal=montotal+costo
    if costo>1000:
        mayormil=mayormil+1
        montmil=montmil+costo
    elif costo>500 and costo<=1000:
        medio=medio+1
        medimont=medimont+costo
    elif costo<=500:
        menorquin=menorquin+1
        montquin=montquin+costo

print(f"Mayores a mil ventas fueron: {mayormil} y el monto total fue de: {montmil}")
print(f"Mayores a 500 pero menores o iguales a 1000 ventas fueron: {medio} y el monto total fue de: {medimont}")
print(f"Menores o igual a 500 ventas fueron: {menorquin} y el monto total fue de: {montquin}")
print(f"Monto total vendido: {montotal}")

