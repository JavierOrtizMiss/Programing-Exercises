#include <stdio.h>
#include <stdlib.h>
int main() {
    int n1,n2,n3, mayor;

    printf("Introduzca 3 numeros");
    scanf("%d", &n1);
    scanf ("%d", &n2);
    scanf ("%d", &n3);

    if (n1>n2 && n1>n3){
        mayor=n1;
    } else if (n2>n1 && n2>n3) {
        mayor=n2;
    } else {
        if (n1,n2,n3==n1,n2,n3){
            printf("Por favor introduce un numero valido");
            exit(1);
        }
        mayor=n3;
    }

    printf("El numero mayor es: %d", mayor);

    return 0;
}