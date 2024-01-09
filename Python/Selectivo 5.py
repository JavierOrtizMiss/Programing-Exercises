#En una tienda efectúan un descuento a los clientes dependiendo del monto de la
#compra. El descuento se efectúa con base en el siguiente criterio:
#Si el monto es menor que $500 — - no hay descuento.
#Si el monto está comprendido entre $500 y $1 000 inclusive — - 5% de descuento.
#Si el monto está comprendido entre $1 000 y $7 000 inclusive — * 11% de descuento.
#Si el monto está comprendido entre $7 000 y $15 000 inclusive — * 18% de descuento.
#Si el monto es mayor a $15 000 — * 25% de descuento.
#Construya un diagrama de flujo y pseudocódigo tal que dado el monto de la compra de un
#cliente, determine lo que se debe pagar.

monto=int(input("Introduzca el monto de la compra: "))

if monto>15000:
    descuento=round(monto*0.75,2)
    print(f"Aplicando el descuento de 25%, la cantidad es: {descuento} ")
else:
    if monto>7000:
        descuento=round(monto*0.82,2)
        print(f"Aplicando el descuento de 18%, la cantidad es: {descuento} ")
    else:
        if monto>1000:
           descuento=round(monto*0.89,2)
           print(f"Aplicando el descuento de 11%, la cantidad es: {descuento} ")
        else:
            if monto>500:
               descuento=round(monto*0.95,2)
               print(f"Aplicando el descuento de 5%, la cantidad es: {descuento} ")
            else:
                print(f"No hay descuento, su cantidad es de {monto}")
                
    