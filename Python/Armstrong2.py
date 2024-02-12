n=int(input("Introduce un número: "))

digitos=0
sum=0
temp=n

while temp>0:
    digitos=digitos + 1
    print(digitos)
    temp=temp//10

temp=n

for i in range(digitos):
    digito= temp %10
    
