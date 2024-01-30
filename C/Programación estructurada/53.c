#include <stdio.h>
#include <ctype.h>
int main() {

    char nota;

    printf("Introduzca la nota: ");
    scanf(" %c", &nota);

    nota=toupper(nota);

    switch (nota){
        case 'A':
            printf("Excelente");
            break;
        case 'B':
            printf("Notable");
            break;
        case 'C':
            printf("Bueno");
            break;
        case 'D':
            printf("Suficiente");
            break;
        case 'E':
            printf("Suspendido");
            break;
        default:
            printf("No es valido");
            break;
    }


    return 0;
}