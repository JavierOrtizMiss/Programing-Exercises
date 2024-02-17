#include <stdio.h>
int main () {
    int n;

    printf("Introduzca un numero: ");
    scanf ("%d", &n);

    if (n<0) {
        printf("El numero es negativo");

    } else if (n==0) {
        printf("El número es igual a cero");
        
    } else {
        printf("El numero es positivo");
    }

    return 0;
}