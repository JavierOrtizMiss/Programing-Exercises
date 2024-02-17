# Pedir al usuario que ingrese un número
num = int(input("Ingrese un número: "))

# Inicializar el número de dígitos y la suma
digitos = 0
suma = 0

# Copiar el número original en una variable temporal
temp = num

# Contar el número de dígitos usando un bucle while
while temp > 0:
  digitos += 1
  temp //= 10

# Restaurar el valor de la variable temporal
temp = num

# Calcular la suma de los dígitos elevados a la potencia del número de dígitos usando otro bucle while
while temp > 0:
  # Obtener el último dígito usando el operador de residuo
  digito = temp % 10
  # Elevar el dígito a la potencia del número de dígitos y agregarlo a la suma
  suma += digito ** digitos
  # Eliminar el último dígito usando la división entera
  temp //= 10

# Comparar la suma con el número original y mostrar el resultado
if suma == num:
  print(num, "es un número armstrong.")
else:
  print(num, "no es un número armstrong.")
