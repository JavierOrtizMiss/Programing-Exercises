#include <stdio.h>

int main() {
    int n, temp, primo = 1;
    
    printf("Introduce un número: ");
    scanf("%d", &n);

    temp = n;

    if (n == 1 || n == 0) {
        primo = 0;
    } else {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                primo = 0;
                break;
            }
        }
    }

    if (primo == 1) {
        printf("%d es un número primo.\n", n);
    } else {
        printf("%d no es un número primo.\n", n);
    }

    return 0;
}
