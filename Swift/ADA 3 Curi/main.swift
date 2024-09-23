import Foundation

let currentFile = #file // Esto nos da la ruta completa del archivo actual (main.swift)
let currentDirectory = URL(fileURLWithPath: currentFile).deletingLastPathComponent().path
let fileURL = URL(fileURLWithPath: currentDirectory).appendingPathComponent("datos.txt")

print("Intentando leer el archivo en: \(fileURL.path)")

do {
    let contenido = try String(contentsOf: fileURL, encoding: .utf8)
    print("Contenido del archivo:")
    print(contenido)
} catch {
    print("Error al leer el archivo: \(error)")
}