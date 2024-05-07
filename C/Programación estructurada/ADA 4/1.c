//Ortiz Miss Javier de Jesus

#include <stdio.h>
#include <string.h>

int strend(char *s, char *t) {
    int letras_s = strlen(s);
    int letras_t = strlen(t);

    if (letras_t > letras_s) //vemos si ambas cadenas tienen la misma longitud
        return 0;

    int i = letras_s - letras_t; // Restamos la longitud de cada cadena para saber donde empezar la comparación
    int j = 0; // inicialización de j

    while (s[i] == t[j]) { //mientras sean igual las letras entra en el bucle
        if (s[i] == '\0' && t[j] == '\0') // ambas cadenas llegaron al final juntas
            return 1;
        i++;
        j++;
    }

    return 0; // si las cadenas son diferentes en algún momento devuelve 0
}

int main() {
    char s[] = "Hola profe";
    char t[] = "profe";

    if (strend(s, t))
        printf("La cadena t se encuentra al final de la cadena s.\n");
    else
        printf("La cadena t no se encuentra al final de la cadena s.\n");

    return 0;
}
