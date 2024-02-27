#include <stdio.h>

int multiplicacion(float a, float b) {
    int resultado = 0;
    
    for (int i = 0; i < (int)b; i++) {
        resultado += a;
    }
    return resultado;
}

int main() {
    float a, b;
    scanf("%f %f", &a, &b);

    printf("%d\n", multiplicacion(a, b));

    return 0;
}
