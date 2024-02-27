//Ortiz Miss Javier de Jesus

#include <stdio.h>
#include <ctype.h>

int main() {
    char caracter;
    int seguir = 1; 

    while (seguir != 0) { 
        printf("Ingrese un caracter ASCII: ");
        scanf(" %c", &caracter);

        if (islower(caracter)==1)
        {
            printf("De minúscula a mayúscula: %c\n", toupper(caracter));
        }
        else if (isupper(caracter)==1)
        {
            printf("De mayúscula a caracter: %c\n", topunct(caracter));
        }
        
    
        printf("¿Es mayúscula? %d\n", isupper(caracter));
        printf("¿Es minúscula? %d\n", islower(caracter));
        printf("¿Es un dígito? %d\n", isdigit(caracter));
        printf("¿Es un símbolo? %d\n", ispunct(caracter));

        printf("¿Desea ingresar otro caracter? (1: Sí / 0: No): ");
        scanf("%d", &seguir); 
    }

    return 0;
}
