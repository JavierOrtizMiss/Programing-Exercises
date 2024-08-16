import Foundation

/*
En una tienda efectúan un descuento a los clientes dependiendo del monto de la
compra. El descuento se efectúa con base en el siguiente criterio:
Si el monto es menor que $500 — - no hay descuento.
Si el monto está comprendido entre $500 y $1 000 inclusive — - 5% de descuento.
Si el monto está comprendido entre $1 000 y $7 000 inclusive — * 11% de descuento.
Si el monto está comprendido entre $7 000 y $15 000 inclusive — * 18% de descuento.
Si el monto es mayor a $15 000 — * 25% de descuento.
Construya un código tal que dado el monto de la compra de un
cliente, determine lo que se debe pagar
*/

func descuento(monto: Double) -> Double {

    let descuentototal:Double
    if monto >= 15000 {
        descuentototal = monto * 0.75
    } else if monto >= 7000 {
        descuentototal = monto * 0.82
    } else if monto >= 1000 {
        descuentototal = monto * 0.89
    } else if monto >= 500 {
        descuentototal = monto * 0.95
    } else {
        descuentototal = monto
    }
        return descuentototal
}
    
print("Introduzca el monto:")

if let input: String=readLine(), let monto:Double=Double(input){
    let montoTotal:Double=descuento(monto: monto)
    print("El monto a pagar es de: \(montoTotal)")
} else {
    print("Entrada no válida")
    
}



    






