#include <stdio.h>

int main() {
    char letra;
    
    printf("Introduzca una letra: ");
    scanf("%c", &letra);

    switch (letra) {
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u':
            printf("Su letra es vocal\n");
            break;
        default:
            printf("Su letra es consonante\n");
            break;
    }

    return 0;
}
