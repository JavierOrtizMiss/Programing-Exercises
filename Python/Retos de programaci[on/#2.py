def son_anagramas(palabra1:str,palabra2:str):
    palabra1=palabra1.lower()
    palabra2=palabra2.lower()
    if len(palabra1)!=len(palabra2): return False
    elif sorted(palabra1)== sorted(palabra2):
        return True
    else:
        return False

anagramas=son_anagramas("Cara","Arca")

print(f"¿Son anagramas? {anagramas}")


    
    
    