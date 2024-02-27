//Ortiz Miss Javier de Jesus

#include <stdio.h>
#include <math.h>

// Función para calcular la distancia entre dos puntos
float distancia(float x1, float y1, float x2, float y2) {
    float puntos1 = x2 - x1;
    float puntos2 = y2 - y1;
    return sqrt(pow(puntos1, 2) + pow(puntos2, 2));
}

int main() {
    float x1, y1, x2, y2, d;

    printf("-----Por favor introduzca el primer punto (x1, y1)---------:\n");
    scanf("%f %f", &x1, &y1);
    printf("-----Por favor introduzca el segundo punto (x2, y2)---------:\n");
    scanf("%f %f", &x2, &y2);

    d = distancia(x1, y1, x2, y2);

    printf("La distancia entre los dos puntos es: %f\n", d);

    return 0;
}
