def obtener_tipo_hamburguesa():
    return input("Tipo de hamburguesa: sencilla, doble o triple\n").lower()

def obtener_cantidad_hamburguesas():
    return int(input("Número de hamburguesas\n"))

def calcular_costo(tipo, cantidad):
    precios = {"sencilla": 20, "doble": 25, "triple": 28}
    return precios.get(tipo, 0) * cantidad

def realizar_pago(costo):
    tarjeta = input("Presione 's' si pagará con tarjeta, de lo contrario, presione 'n'\n")
    return costo * 1.05 if tarjeta == "s" else costo

def main():
    print("Introduzca cuántas personas comprarán")
    personas = int(input())
    sumador = 0

    for contador in range(1, personas + 1):
        print(f"--------------------Persona {contador}--------------------")
        tipo = obtener_tipo_hamburguesa()
        cantidad = obtener_cantidad_hamburguesas()

        costo = calcular_costo(tipo, cantidad)
        total_pagar = realizar_pago(costo)

        print(f"El pago total con el cargo es de {total_pagar}" if tarjeta == "s" else f"El pago total es de {total_pagar}")
        sumador += total_pagar

    print(f"El total a pagar con las {personas} personas es de {sumador}")

if __name__ == "__main__":
    main()
