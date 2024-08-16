import Foundation

/*
Dado como dato el sueldo de un trabajador, aplíquele un aumento del 15% si su
sueldo es inferior a $1000. Imprima en este caso el nuevo sueldo del trabajador.
*/

func applymore(sueldo:Double){
    if sueldo<1000 {
        let aumento=sueldo*0.15
        let newsueldo:Double = sueldo + aumento
        print("El nuevo sueldo es de: \(newsueldo)")
    } else {
        print("El sueldo del trabajador es de: \(sueldo)")
    }

}

print("Introduce el sueldo del trabajador")

if let input=readLine(), let sueldoT=Double(input){
    applymore(sueldo: sueldoT)
} else {
    print("Entrada no válida")
}


