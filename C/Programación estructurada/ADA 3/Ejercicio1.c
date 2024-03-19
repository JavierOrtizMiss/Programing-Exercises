#include <stdio.h>

// Definir la función para buscar la intersección de dos conjuntos
void interseccion(int conjuntoA[], int conjuntoB[], int tamañoA, int tamañoB) {
    printf("Intersección: ");
    for (int i = 0; i < tamañoA; i++) {
        for (int j = 0; j < tamañoB; j++) {
            if (conjuntoA[i] == conjuntoB[j]) {
                printf("%d ", conjuntoA[i]);
                break; 
            }
        }
    }
    printf("\n");
}

int main() {
    int conjuntoA[100], conjuntoB[100];
    int tamañoA, tamañoB;

    // Leer el primer conjunto
    printf("Ingrese el tamaño del conjunto A: ");
    scanf("%d", &tamañoA);
    printf("Ingrese los elementos del conjunto A:\n");
    for (int i = 0; i < tamañoA; i++) {
        scanf("%d", &conjuntoA[i]);
    }

    // Leer el segundo conjunto
    printf("Ingrese el tamaño del conjunto B: ");
    scanf("%d", &tamañoB);
    printf("Ingrese los elementos del conjunto B:\n");
    for (int i = 0; i < tamañoB; i++) {
        scanf("%d", &conjuntoB[i]);
    }

    // Llamar a la función para encontrar la intersección
    interseccion(conjuntoA, conjuntoB, tamañoA, tamañoB);

    return 0;
}
