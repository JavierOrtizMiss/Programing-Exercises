#include <stdio.h>
int main(){
    float sueldo,aumento;

    printf("Escriba el sueldo del trabajador: ");
    scanf("%f",&sueldo);

    if(sueldo<1000) {
        aumento = sueldo*1.15;
        printf("Su sueldo con aumento es de: %.1f", aumento);
    } else {
        printf("Su sueldo es %.1f y no ha cambiado", sueldo);
    }

    return 0;
}