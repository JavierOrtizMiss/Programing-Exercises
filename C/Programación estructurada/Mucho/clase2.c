#include <stdio.h>
int main() {
    int numero;
    char letra;

    printf("Escriba un n%cmero: ", 163);
    numero=getchar();

    printf("\nUsted escribio:%c", numero);
    
    fflush(stdin);

    printf("\nEscriba una letra: ");
    letra=getchar();

    printf("\nUsted escribio: %c", letra);


    return 0;
}