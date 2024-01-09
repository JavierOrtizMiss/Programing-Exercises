sumador=0
def saving_month():
    for i in range(1,13):
        deposito=float(input(f"Introduzca su deposito del mes {i}: "))
        global sumador
        sumador+=deposito
        print(f"En el mes {i} lleva ahorrado {sumador}")

def saving_year():
    return print(f"En el año ahorró {sumador}")

saving_month()
saving_year()      
    
    
    
    

