#include <stdio.h>

int esdigito(int c) {
    if (c >= 0 && c <= 9) {
        return 1;
    } else {
        return 0;
    }
}

int esletra(char c) {
    switch (c) {
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
            return 1;
        default:
            return 0;
    }
}

int esalfanum(char c) {
    if (esletra(c) || esdigito(c)) {
        return 1;
    } else {
        return 0;
    }
}
int esblanco(char c){
    if (c==' ') {
        return 1;
    } else {
        return 0;
    }


}
int main() {
    char c = ' ';
    printf("Es dígito: %d\n", esdigito(c));
    printf("Es letra: %d\n", esletra(c));
    printf("Es alfanumérico: %d\n", esalfanum(c));
    printf("Es blanco: %d\n", esblanco(c));

    return 0;
}
