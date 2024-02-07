#include <stdio.h>
int main() {
    float b1,h1,b2,h2,a1,a2;

    printf("Introduzca la base y la altura del primer triangulo: ");
    scanf(" %f", &b1);
    scanf(" %f", &h1);
    printf("Introduzca la base y la altura del segundo triangulo: ");
    scanf(" %f", &b2);
    scanf(" %f", &h2);

    a1=b1*h1/2;
    a2=b2*h2/2;

    if (a1>a2) {
        printf("El segundo triangulo es menor");
    } else{
        printf("El primer triangulo es menor");
    }




    return 0;
}