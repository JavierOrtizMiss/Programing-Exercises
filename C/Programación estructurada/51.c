#include <stdio.h>

int main() {
    char op;
    float n1, n2, resultado;

    printf("Introduzca dos numeros: ");
    scanf("%f", &n1);
    scanf("%f", &n2);

    printf("Introduzca la operación que quiere hacer (a=suma, b=resta, c=multiplicacion, d=division): ");
    scanf(" %c", &op);  

    switch (op) {
        case 'a':
            resultado = n1 + n2;
            printf("El resultado es: %f", resultado);
            break;
        case 'b':
            resultado = n1 - n2;
            printf("El resultado es: %f", resultado);
            break;
        case 'c':
            resultado = n1 * n2;
            printf("El resultado es: %f", resultado);
            break;
        case 'd':
            if (n2 != 0) {
                resultado = n1 / n2;
                printf("El resultado es: %f", resultado);
            } else {
                printf("No es posible dividir por cero");
            }
            break;
        default:
            printf("No es valido");
            break;
    }

    return 0;
}
