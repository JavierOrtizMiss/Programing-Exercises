#Este código es de la primera tarea

nombreDino=input("Escriba el nombre del dinosaurio: ")
pesoLibras=float(input("Escriba el peso del dinosaurio en libras: "))
longitudpies=float(input("Escriba su longitud en pies: "))

pesoKG=pesoLibras*0.4535
longitudmetros=longitudpies*0.3048

print(f"Nombre: {nombreDino}")
print(f"La longitud en metros es: {longitudmetros}")
print(f"El peso en kilogramos es: {pesoKG}")