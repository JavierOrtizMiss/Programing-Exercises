#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_FRASES 10
#define MAX_LONGITUD_FRASE 100

int main() {
    char **pfrases; 
    int num_frases;

    printf("Ingrese el número de frases que desea ingresar (máximo %d): ", MAX_FRASES);
    scanf("%d", &num_frases);

    if (num_frases > MAX_FRASES || num_frases <= 0) {
        printf("Número de frases no válido.\n");
        return 1; 
    }

    // Asignar memoria para el arreglo de punteros a char
    pfrases = (char **)malloc(num_frases * sizeof(char *));
    if (pfrases == NULL) {
        printf("Error de asignación de memoria.\n");
        return 1; // Salida con error
    }

    // Leer y almacenar las frases
    for (int i = 0; i < num_frases; i++) {
        char frase[MAX_LONGITUD_FRASE];

        printf("Ingrese la frase %d: ", i + 1);
        scanf(" %[^\n]", frase); // Leemos la frase completa hasta que se presiona Enter

        // Reservamos memoria para la frase y copiamos su contenido
        pfrases[i] = (char *)malloc((strlen(frase) + 1) * sizeof(char));
        if (pfrases[i] == NULL) {
            printf("Error de asignación de memoria.\n");
            return 1; // Salida con error
        }
        strcpy(pfrases[i], frase);
    }

    // Imprimir las frases almacenadas
    printf("\nLas frases ingresadas son:\n");
    for (int i = 0; i < num_frases; i++) {
        printf("%s\n", pfrases[i]);
    }

    // Liberar la memoria reservada
    for (int i = 0; i < num_frases; i++) {
        free(pfrases[i]);
    }
    free(pfrases);

    return 0; // Salida exitosa
}
