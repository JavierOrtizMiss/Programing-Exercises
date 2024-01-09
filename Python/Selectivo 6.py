precioinicial = float(input("Introduzca el precio inicial: "))

tipo = input("Introduzca el tipo, si es A o B: ")
if tipo not in ["A", "B"]:
    print("Por favor, ingrese solo A o B.")
    exit()

kilos = int(input("Introduzca la cantidad de kilos: "))

size = int(input("Introduzca el tamaño, si es 1 o 2: "))
if size not in [1, 2]:
    print("Por favor, ingrese solo 1 o 2 para el tamaño.")
    exit()

if tipo == "A":
    if size == 1:
        preciototal = precioinicial + 2
    elif size == 2:
        preciototal = precioinicial + 3
else:
    if size == 1:
        preciototal = precioinicial - 3
    elif size == 2:
        preciototal = precioinicial - 5

cantidad = preciototal * kilos
print(f"El pago total es de {cantidad}")
