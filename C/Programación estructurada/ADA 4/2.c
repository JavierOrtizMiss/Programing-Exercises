//Ortiz Miss Javier de Jesus

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_FRASES 3
#define MAX_EXTENSION_FRASES 100

int main() {
    char **frase_ingresada; 
    int num_frases;

    printf("Ingrese el número de frases que desea ingresar (máximo %d): ", MAX_FRASES);
    scanf("%d", &num_frases);

    if (num_frases > MAX_FRASES || num_frases <= 0) {
        printf("Número de frases no válido.\n");
        return 1; 
    }

    // Asignar memoria para el arreglo de punteros a char
    frase_ingresada = (char **)malloc(num_frases * sizeof(char *));
    if (frase_ingresada == NULL) {
        printf("Error de asignación de memoria.\n");
        return 1; // Salida con error
    }

    // Leer y almacenar las frases
    for (int i = 0; i < num_frases; i++) {
        char frase[MAX_EXTENSION_FRASES];

        printf("Ingrese la frase %d: ", i + 1);
        scanf(" %[^\n]", frase); // Leemos la frase completa hasta que se presiona Enter

        // Reservamos memoria para la frase y copiamos su contenido
        frase_ingresada[i] = (char *)malloc((strlen(frase) + 1) * sizeof(char));
        if (frase_ingresada[i] == NULL) {
            printf("Error de asignación de memoria.\n");
            return 1; // Salida con error
        }
        strcpy(frase_ingresada[i], frase);
    }

    // Imprimir las frases almacenadas
    printf("\nLas frases ingresadas son:\n");
    for (int i = 0; i < num_frases; i++) {
        printf("%s\n", frase_ingresada[i]);
    }

    // Liberar la memoria reservada
    for (int i = 0; i < num_frases; i++) {
        free(frase_ingresada[i]);
    }
    free(frase_ingresada);

    return 0; // Salida exitosa
}
