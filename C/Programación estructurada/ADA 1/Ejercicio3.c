#include <stdio.h>

int main() {
    // Declarar variables
    char reactivo1, reactivo2;

    printf("Introduzca dos reactivos (a, b, c o d): ");
    scanf(" %c %c", &reactivo1, &reactivo2); 


    if (reactivo1 == 'a' && reactivo2 == 'b' || reactivo1 == 'b' && reactivo2 == 'a') {
        printf("La mezcla de a y b explota.\n");
    } else if ((reactivo1 == 'b' && reactivo2 == 'c') || (reactivo1 == 'c' && reactivo2 == 'b')) {
        printf("La mezcla de b y c genera escarcha.\n");
    } else if ((reactivo1 == 'a' && reactivo2 == 'c') || (reactivo1 == 'c' && reactivo2 == 'a')) {
        printf("La mezcla de a y c genera calor.\n");
    } else if ((reactivo1 == 'd' && reactivo2 != 'c') || (reactivo1 != 'c' && reactivo2 == 'd')) {
        printf("La mezcla con d genera espuma.\n");
    } else if (reactivo1 == 'c' && reactivo2 == 'd') {
        printf("La mezcla de c y d explota.\n");
    } else {
        printf("No hay reacción definida para esta combinación de reactivos.\n");
    }

    return 0;
}
