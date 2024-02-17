#include <stdio.h>
int main() {
    float m1, m2;
    float r, G=6.67, F;

    printf("Introduzca el valor de la masa m1: ");
    scanf ("%f", &m1);
    printf("Introduzca el valor de la masa m2: ");
    scanf ("%f", &m2);

    r=120;

    if (m1>0 && m2>0)  {
        F=G*((m1*m2)/(r*r));
        printf("%f", F);
    } else {
        return;
    }


    return 0;
}

