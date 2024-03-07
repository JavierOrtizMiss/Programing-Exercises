#include <stdio.h>

#define MAX 50

// Función para leer valores para un vector
void leerVector(int vector[], int longitud) {
    printf("Introduce los valores del vector:\n");
    for (int i = 0; i < longitud; i++) {
        printf("Valor para el elemento %d: ", i);
        scanf("%d", &vector[i]);
    }
}

// Función para imprimir el contenido de un vector
void imprimirVector(int vector[], int longitud) {
    printf("Contenido del vector:\n");
    for (int i = 0; i < longitud; i++) {
        printf("%d ", vector[i]);
    }
    printf("\n");
}

// Función para sumar dos vectores
void sumarVectores(int v1[], int v2[], int resultado[], int longitud) {
    for (int i = 0; i < longitud; i++) {
        resultado[i] = v1[i] + v2[i];
    }
}

// Función para restar dos vectores
void restarVectores(int v1[], int v2[], int resultado[], int longitud) {
    for (int i = 0; i < longitud; i++) {
        resultado[i] = v1[i] - v2[i];
    }
}

// Función para poner en cero un vector
void ponerEnCero(int vector[], int longitud) {
    for (int i = 0; i < longitud; i++) {
        vector[i] = 0;
    }
}

// Función para llenar un vector de unos
void llenarUnos(int vector[], int longitud) {
    for (int i = 0; i < longitud; i++) {
        vector[i] = 1;
    }
}

int main() {
    int v1[MAX], v2[MAX], v3[MAX];

    // Lectura de valores para el primer vector
    leerVector(v1, MAX);

    // Impresión del contenido del primer vector
    printf("Primer vector:\n");
    imprimirVector(v1, MAX);

    // Lectura de valores para el segundo vector
    leerVector(v2, MAX);

    // Impresión del contenido del segundo vector
    printf("Segundo vector:\n");
    imprimirVector(v2, MAX);

    // Suma de los dos vectores
    sumarVectores(v1, v2, v3, MAX);
    printf("Resultado de la suma:\n");
    imprimirVector(v3, MAX);

    // Resta de los dos vectores
    restarVectores(v2, v1, v3, MAX);
    printf("Resultado de la resta:\n");
    imprimirVector(v3, MAX);

    // Poner en cero un vector
    ponerEnCero(v1, MAX);
    printf("Primer vector puesto en cero:\n");
    imprimirVector(v1, MAX);

    // Llenar un vector de unos
    llenarUnos(v2, MAX);
    printf("Segundo vector llenado de unos:\n");
    imprimirVector(v2, MAX);

    return 0;
}
