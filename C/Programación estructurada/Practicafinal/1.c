#include <stdio.h>
#include <string.h>

void concatenar(char *cadena1, char *cadena2) {
    int len1 = strlen(cadena1);
    int len2 = strlen(cadena2);

    char cadena3[len1 + len2 + 1]; // +1 para el carácter nulo
    
    // Copiar cadena1 en cadena3
    strcpy(cadena3, cadena1);

    // Concatenar cadena2 a cadena3
    strcat(cadena3, cadena2);

    // Imprimir el resultado de la concatenación
    printf("Cadena concatenada: %s\n", cadena3);
}

int main() {
    char cadena1[100];
    char cadena2[100];

    // Pedir al usuario la primera cadena
    printf("Dame la primera cadena: ");
    scanf("%99s", cadena1); // Limitar el número de caracteres leídos para evitar desbordamientos

    // Pedir al usuario la segunda cadena
    printf("Dame la segunda cadena: ");
    scanf("%99s", cadena2); // Limitar el número de caracteres leídos para evitar desbordamientos

    // Llamar a la función concatenar
    concatenar(cadena1, cadena2);

    return 0;
}
