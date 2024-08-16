import Foundation

/*
Construya un diagrama de flujo y pseudocódigo tales que dado como dato el sueldo de un trabajador,
le aplique un aumento del 15% si su sueldo es inferior a $1000 y 12% en caso
contrario. Imprima el nuevo sueldo del trabajador.
*/

func aumentoSueldo(sueldo: Double) -> Double {
    let sueldoAumento: Double
    if sueldo < 1000 {
        sueldoAumento = sueldo * 1.15
    } else {
        sueldoAumento = sueldo * 1.12
    }
    return sueldoAumento
}

print("Introduzca el sueldo del trabajador")

if let input = readLine(), let sueldo = Double(input) {
    let nuevoSueldo = aumentoSueldo(sueldo: sueldo)
    print("El nuevo sueldo del trabajador es \(nuevoSueldo)")
} else {
    print("Entrada inválida. Por favor, introduzca un número válido.")
}
