#include <stdio.h>
int main() {
    int numero;
    char letra;

    printf("Escriba un n%cmero: ", 163);
    numero=getchar();

    putchar(numero);
    
    fflush(stdin);

    printf("\nEscriba una letra: ");
    letra=getchar();

    putchar(letra);


    return 0;
}