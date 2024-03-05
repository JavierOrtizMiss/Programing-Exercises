#include <stdio.h>

char impri(char c){
    
    while (scanf("%c", &c) == 1) {
        printf("%c", c);
    }

    return c;
}

int main() {
    char c;

    printf("Escribe un texto. Presiona Enter para imprimirlo:\n");
    printf("%c", impri(c));
    return 0;
}
