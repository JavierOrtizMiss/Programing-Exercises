# include <stdio.h>
int main() {
    int n;
    int ans;

    printf("Introduzca un número: ");
    scanf ("%d", &n);
    printf("Si desea que se muestre en codigo ASCII escriba 1, sino 2");
    scanf ("%d", &ans);

    if (ans==1) {
        printf("Su número en ASCII es: %c",n);
    } else {
        printf("Su numero es: %d", n);
    }


    return 0;
}