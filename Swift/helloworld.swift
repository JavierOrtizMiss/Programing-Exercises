import Foundation

// Función principal
func main() {
    // Solicitar el nombre del usuario
    print("¿Cuál es tu nombre?")
    
    // Leer la entrada del usuario
    if let nombre = readLine() {
        // Imprimir el nombre del usuario
        print("Hola, \(nombre)!")
    } else {
        print("No se pudo leer el nombre.")
    }
}

// Llamar a la función principal
main()

