//Ortiz Miss Javier de Jesus             Ejercicio 5
 
#include <stdio.h>

int main() {
    float sueldo_base, incentivo, sueldo_total;
    int antiguedad;

    // Solicitar al usuario el sueldo base y la antigüedad del empleado
    printf("Ingrese el sueldo base del empleado: ");
    scanf("%f", &sueldo_base);

    printf("Ingrese la antigüedad del empleado en años: ");
    scanf("%d", &antiguedad);

    // Calcular el incentivo en base a la antiguedad del empleado
    if (antiguedad >= 1 && antiguedad <= 3) {
        incentivo = sueldo_base * 0.01;
    } else if (antiguedad >= 4 && antiguedad <= 6) {
        incentivo = sueldo_base * 0.03;
    } else if (antiguedad >= 7 && antiguedad <= 9) {
        incentivo = sueldo_base * 0.05;
    } else if (antiguedad >= 10) {
        incentivo = sueldo_base * 0.07;
    } else {
        // Si la antigüedad no está en ninguno de los rangos especificados
        incentivo = 0;
        printf("La antiguedad no es válida\n");
    }

    // Calcular el sueldo total a pagar
    sueldo_total = sueldo_base + incentivo;

    // Imprimir los resultados
    printf("Sueldo base: %.2f\n", sueldo_base);
    printf("Incentivo: %.2f\n", incentivo);
    printf("Sueldo total a pagar: %.2f\n", sueldo_total);

    return 0;
}
