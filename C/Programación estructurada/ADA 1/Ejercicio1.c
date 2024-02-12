#include <stdio.h>
int main(){
    int n1,n2,n3,mayor;

    printf("Introduzca el primer número: ");
    scanf("%d", &n1);
    printf("Introduzca el segundo número: ");
    scanf("%d", &n2);
    printf("Introduzca el tercer número: ");
    scanf("%d", &n3);

    if (n1 > n2 && n1 > n3) {
        mayor = n1;
    } else if (n2 > n3) {
        mayor = n2;
    } else {
        mayor = n3;
    }

    printf("El mayor de los tres números es: %d\n", mayor);

    return 0;
}
