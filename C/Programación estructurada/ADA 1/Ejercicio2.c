//Ortiz Miss Javier de Jesus       Ejercicio 2

#include <stdio.h>
int main() {
    //Declaramos la variable calificación como entero
    int calificacion;
    // Le pedimos al usuario que introduzca la calificación
    printf("Introduzca la calificación: \n");
    scanf("%d", &calificacion);

    // Condición que si la calificación se encuentra en el rango de (91-100) imprima
    // "Excelente"
    if (calificacion<=100 && calificacion>=91){
        printf("Excelente");
    }
    //Condición rango (81-90)imprimir "Muy bien"
    else if (calificacion<=90 && calificacion>=81) {
        printf("Muy bien");
    }
    //Condición rango (71-80) imprimir "Bien"
    else if (calificacion<=80 && calificacion>=71) {
        printf("Bien");
    }
    // Condción rang (61-70) imprimir "Regular"
    else if (calificacion<=70 && calificacion>=61) {
        printf("Regular");
    }
    //Condición si calicación==60 entonces imprima "Suficiente"
    else if (calificacion==60){
        printf("Suficiente");
    }
    // Sino se cumplen las condiciones anteriores imprimir "Reprobado"
    else {
        printf("Reprobado");
    }

    return 0;
}