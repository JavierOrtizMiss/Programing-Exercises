#include <stdio.h>
int main() {
    // Reciba un numero del 1-7 y imprimir el nombre del día
    int dia;

    printf("Escribe un numero (1-7): ");
    scanf("%d", &dia);

    switch (dia)
    {
    case 1:
        printf("Lunes");
        break;
    
    case 2:
        printf("Martes");
        break;
    case 3:
        printf("Miercoles");
        break;
    case 4:
        printf("Jueves");
        break;
    case 5:
        printf("Viernes");
        break;
    case 6:
        printf("Sabado");
        break;
    case 7:
        printf("Domingo");
        break;
    default:
        printf("No valido");
    }

    return 0;
}