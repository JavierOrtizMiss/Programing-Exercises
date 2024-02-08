#include <stdio.h>

int suma(int num1, int num2) {
    int resultado;
    resultado =num1 + num2;
    return resultado;
}
int main () {
    int numero1, numero2, operacion;

    printf("Introduzca el primero número: ");
    scanf("%d",&numero1);
    printf("\nEscribe el segundo número: ");
    scanf("%d",&numero2);

    operacion=suma(numero1,numero2);
    printf("%d",operacion);


    return 0;

}