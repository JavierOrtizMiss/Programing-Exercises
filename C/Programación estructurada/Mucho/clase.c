#include <stdio.h>
#define G 6.67
int main(){
    float m1, m2, r, F;

    m1=150.20;
    m2= 300.40;
    r=120;

    F=G*((m1*m2)/(r*r));
    printf("%f", F);

    return 0;
}