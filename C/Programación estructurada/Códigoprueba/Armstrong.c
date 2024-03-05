#include <stdio.h>
#include <math.h>

int main() {
    int n, digitos, sum, temp, resto;

    printf("Introduzca un número: ");
    scanf("%d", &n);

    digitos = 0;
    sum = 0;
    temp = n;

    
    while (temp > 0) {
        digitos += 1;
        temp /= 10;
    }

    temp = n;

    
    while (temp > 0) {
        resto = temp % 10;
        sum += pow(resto, digitos);
        temp /= 10;
    }

    if (sum == n) {
        printf("%d es un número de Armstrong.\n", n);
    } else {
        printf("%d no es un número de Armstrong.\n", n);
    }

    return 0;
}
