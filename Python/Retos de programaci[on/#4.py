def es_primo(n:int):
    if n==0 or n==1:
        return n
    else:
        for i in range (2,n):
            if n%i==0:
                return False
            else:
                return True
        else:
            return True
def primos():
    primos_lista=[i for i in range(2, 101) if es_primo(i)]
    print(primos_lista)
    
def primos_buscar(n):
    if es_primo(n)==True:
        print("Tú número es primo")
    else:
        print("Tú número no es primo")

primos_buscar(2)
primos()
