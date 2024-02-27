#include <stdio.h>

int factorial(int n) {
    int result = 1;
    int i = 1;
    while (i <= n) {
        result *= i;
        i++;
    }
    return result;
}

int main() {
    int n, resultado;
    
    printf("Ingrese el número de elementos: ");
    scanf("%d", &n);
    
    resultado = factorial(n);
    
    printf("El factorial de %d es: %d\n", n, resultado);
    
    return 0;
}
