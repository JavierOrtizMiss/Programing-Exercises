#include <stdio.h>
int main(){
    int numero;

    printf("Ingrese un número: ");scanf("%d",&numero);

    if (numero<0) {
        printf("El numero %d es negativo", numero);
    } else {
        printf("El numero %d es positivo", numero);
    }

    return 0;
}