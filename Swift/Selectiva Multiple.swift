import Foundation

/*
Una empresa telefónica establece el costo de las llamadas telefónicas internacionales según la zona geográfica en la que se encuentre el país destino y del número de minutos hablados. En la siguiente tabla se presenta el costo del minuto por zona. A cada zona se le ha asociado una clave.
*/

// Función para calcular el costo de la llamada
func calcularCostoLlamada(clave: Int, tiempo: Int) -> Double? {
    var costoTotal: Double
    
    switch clave {
    case 12:
        costoTotal = Double(tiempo) * 2.0
    case 15:
        costoTotal = Double(tiempo) * 2.2
    case 18:
        costoTotal = Double(tiempo) * 4.5
    case 19:
        costoTotal = Double(tiempo) * 3.5
    case 23:
        costoTotal = Double(tiempo) * 6.0
    case 25:
        costoTotal = Double(tiempo) * 6.0
    case 29:
        costoTotal = Double(tiempo) * 5.0
    default:
        print("Clave no válida")
        return nil
    }
    
    return costoTotal
}

// Solicitar al usuario que ingrese los datos
print("Ingrese la clave de la zona: ", terminator: "")
if let inputClave = readLine(), let clave = Int(inputClave) {
    print("Ingrese el número de minutos hablados: ", terminator: "")
    if let inputTiempo = readLine(), let tiempo = Int(inputTiempo) {
        if let costo = calcularCostoLlamada(clave: clave, tiempo: tiempo) {
            print("El costo total de la llamada es: \(costo)")
        } else {
            print("No se pudo calcular el costo de la llamada debido a una clave no válida.")
        }
    } else {
        print("Entrada de tiempo no válida")
    }
} else {
    print("Entrada de clave no válida")
}
