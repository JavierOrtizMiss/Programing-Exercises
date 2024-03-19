#include <stdio.h>
#include <string.h>

// Función para determinar si una cadena es un palíndromo
int esPalindromo(char cad[]) {
    int longitud = strlen(cad);
    int inicio = 0;
    int fin = longitud - 1;

    while (fin > inicio) {
        if (cad[inicio++] != cad[fin--]) {
            // Si los caracteres en posiciones opuestas no son iguales, no es un palíndromo
            return 0;
        }
    }

    // Si el bucle se completa sin encontrar una discrepancia, es un palíndromo
    return 1;
}

int main() {
    char frase[100];

    printf("Introduce una frase: ");
    fgets(frase, sizeof(frase), stdin);

    // Eliminar el salto de línea final de fgets
    frase[strcspn(frase, "\n")] = 0;

    // Verificar si la frase es un palíndromo
    if (esPalindromo(frase)) {
        printf("La frase es un palíndromo.\n");
    } else {
        printf("La frase no es un palíndromo.\n");
    }

    return 0;
}
