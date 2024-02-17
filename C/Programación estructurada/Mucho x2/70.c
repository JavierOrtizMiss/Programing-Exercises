#include <stdio.h>
int main() {
    float pv,pm,v, m, total;

    printf("Introduzca el numero de varones: ");
    scanf(" %d", &v);
    printf("Introduzca el numero de mujeres: ");
    scanf(" %d", &m);

    total=v+m;
    pv=v/total*100;
    pm=m/total*100;

    printf("Hay %f%% de varones\n", pv);
    printf("Hay %f%% de mujeres\n", pm);

    if (m>total/2) {
        printf("Hay más mujeres que hombres");
    } else {
        printf("Hay más hombres que mujeres");
    }








    return 0;
}