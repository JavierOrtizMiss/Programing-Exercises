#include <stdio.h> 
#include <math.h>

int main() {
    float x1, y1, x2, y2, d;

    printf("-----Por favor introduzca el primer punto (x1, y1)---------\n");
    scanf("%f %f", &x1, &y1);
    printf("-----Por favor introduzca el segundo punto (x2, y2)---------\n");
    scanf("%f %f", &x2, &y2);

    float puntos1 = x2 - x1;
    float puntos2 = y2 - y1;

    d = sqrt(pow(puntos1, 2) + pow(puntos2, 2));

    printf("La distancia entre los dos puntos es: %f\n", d);

    return 0;
}
