//Ortiz Miss Javier de Jesus

#include <stdio.h>

//Función para multiplicar
int multiplicacion(float a, float b) {
    int resultado = 0;
    
    for (int i = 0; i < (float)b; i++) {
        resultado += a;
    }
    return resultado;
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
    if (n == 0)
        return 1;
    else
        return n * factorial(n - 1);
}

// Función para calcular la potencia de un número
int potencia(int base, int exponente) {
    int resultado = 1;
    for (int i = 0; i < exponente; i++) {
        resultado *= base;
    }
    return resultado;
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