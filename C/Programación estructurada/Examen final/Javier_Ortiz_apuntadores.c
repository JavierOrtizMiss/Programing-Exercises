//Ortiz Miss Javier de Jesus

#include <stdio.h>

int cuenta(char *s) {
    int contador = 0;
    while (*s != '\0') {
        switch (*s) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                contador++;
        }
        s++;
    }
    return contador;
}

int main() {
    char s[100];
    printf("Ingrese una cadena de caracteres: ");
    scanf("%s", s);

    int cantidad_vocales = cuenta(s);
    printf("La cantidad de vocales en la cadena es: %d\n", cantidad_vocales);

    return 0;
}
