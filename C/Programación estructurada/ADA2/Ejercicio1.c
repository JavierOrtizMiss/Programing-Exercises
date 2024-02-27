//Ortiz Miss Javier de Jesus

#include <stdio.h>

//Función para multiplicar
int multiplicacion(float a, float b) {
    int result = 0;
    
    for (int i = 0; i < (float)b; i++) {
        result += a;
    }
    return result;
}

// Función para calcular el número de Fibonacci dado su posición n
int fibonacci(int n) {
    if (n <= 1){
        return n-1;
    }
    else if (n==2){
        return n-1;
    }
    else {
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

// Función para calcular el factorial de un número
int factorial(int n) {
    int result = 1;
    int i = 1;
    while (i <= n) {
        result *= i;
        i++;
    }
    return result;
}

// Función para calcular la potencia de un número
int potencia(int base, int exponente) {
    int result = 1;
    int i=1;
    while (i<=exponente){
        result=base*i;
        i++;
    }
    return result;
}

int main() {
    // Prueba de la función de multiplicación
    printf("Multiplicación: %d\n", multiplicacion(5, 3));

    // Prueba de la función de Fibonacci
    printf("Fibonacci: %d\n", fibonacci(7));

    // Prueba de la función de factorial
    printf("Factorial: %d\n", factorial(5));

    // Prueba de la función de potencia
    printf("Potencia: %d\n", potencia(2, 3));

    return 0;
}