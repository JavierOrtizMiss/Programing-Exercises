#include <stdio.h>
#include <string.h>
#include <ctype.h> 

int main() {
    char frase[1000]; 
    printf("Ingrese una frase: ");
    fgets(frase, sizeof(frase), stdin);
    
    if (frase[strlen(frase) - 1] == '\n') {
        frase[strlen(frase) - 1] = '\0'; 
    }
    
    printf("La frase ingresada es: %s\n", frase); 
    printf("La longitud de la frase es: %zu\n", strlen(frase)); 

    int contador[10] = {0}, longitud_palabra = 0; 


    for (int i = 0; frase[i] != '\0'; i++) {
        if (isalpha(frase[i])) { 
            longitud_palabra++; 
        } else if (longitud_palabra > 0) { 
            if (longitud_palabra <= 9) { 
                contador[longitud_palabra]++; 
            } else { 
                contador[9]++; 
            }
            longitud_palabra = 0;
        }
    }
    

    if (longitud_palabra > 0) {
        if (longitud_palabra <= 9) { 
            contador[longitud_palabra]++; 
        } else { 
            contador[9]++; 
        }
    }

    for (int i = 1; i <= 9; i++) {
        printf("Palabras de %d letras: %d\n", i, contador[i]);
    }

    return 0;
}
