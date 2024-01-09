horas_totales = 0

def registro():
    for dia in range(1,7):  
        horas = float(input(f"Introduzca las horas trabajadas en el día {dia}: "))
        global horas_totales  
        horas_totales += horas
    

def sueldo():
    tarifa_hora = float(input("Introduzca la tarifa por hora: "))
    salario = horas_totales * tarifa_hora
    horas_all=int(horas_totales)
    print(f"El total de horas trabajadas es: {horas_all} horas")
    print("El sueldo a recibir es: $", round(salario,2))


registro()
sueldo()
