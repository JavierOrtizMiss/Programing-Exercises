
sueldo=int(input("Introduce el sueldo del trabajador: "))

if sueldo<1000:
    aumento=round(sueldo*1.15,2)
    print(f"El sueldo del trabajador con aumento del 15% es {aumento}")
else:
   aumento=round(sueldo*1.12,2)
   print(f"El sueldo del trabajador con aumento del 12% es: {aumento}")