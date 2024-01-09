#Examen de sonidos de un grillo convertirto en temperatura farenheit y celsius pero n no puede ser negativo

N=int(input("Introduce el número de sonidos: "))

if N>0:
    T=N/4+40
    C=(T-32)*5/9
    print(f"Número de sonidos son:  {N}")
    print(f"Temperatura en farenheit:  {T}")
    print(f"Temperatura en grados celsius: {C}")
else:
    print("N no puede ser negativo")