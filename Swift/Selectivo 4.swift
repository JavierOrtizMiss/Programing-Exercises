import Foundation

/* 
Realice un algoritmo para determinar cuánto se debe pagar por una cierta cantidad de lápices considerando que, si son 1000 lápices o más, el costo es de 2 pesos; de lo contrario, el precio es de 2.50 pesos. Represéntelo con el pseudocódigo y el diagrama de flujo 
*/

func paga(lapices:Double)-> Double{
    let costo:Double
    if lapices >= 1000 {
         costo = lapices * 2
    } else {
        costo = lapices * 2.50
    }
    return costo
}

print("Introduzca la cantidad de lapices: ")

if let input:String=readLine(), let lapices:Double=Double(input){
    let costoTotal: Double = paga(lapices: lapices)
    print("El costo total de \(lapices) lapices, es de: \(costoTotal)")
} else {
    print("Entrada inválida")
}
