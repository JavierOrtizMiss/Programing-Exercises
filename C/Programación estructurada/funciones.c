#include <stdio.h>
   void imprimir(int numero) {
        
        printf("El número es %d", numero);
    }
int main() {
    int Unnumero;

    printf("Escriba un número: " );
    scanf("%d",&Unnumero);

    imprimir(Unnumero);

    return 0;
}