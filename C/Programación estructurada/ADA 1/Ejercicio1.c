//Ortiz Miss Javier de Jesus      Ejercicio 1
#include <stdio.h>
int main(){
    //Declaramos las variables que utilizaremos
    int n1,n2,n3,mayor;

    //Hacemos que el usuario introduzca los tres numeros mediante el scanf
    printf("Introduzca el primer número: ");
    scanf("%d", &n1);
    printf("Introduzca el segundo número: ");
    scanf("%d", &n2);
    printf("Introduzca el tercer número: ");
    scanf("%d", &n3);

    //En el primer if preguntamos si n1 es mayor a n2 y n3, si es así entonces n1 es el mayor
    if (n1 > n2 && n1 > n3) {
        mayor = n1;
    } 
    //Hacemos un else if para volver a preguntar en dado caso que la primera condición no se
    //cumpla. Preguntamos si n2 es mayor a n3 y si se cumple n2 es el mayor.

    else if (n2 > n3) {
        mayor = n2;
    } 
    // Si no se cumplen las primeras dos condiciones, entnces el mayor es n3
    else {
        mayor = n3;
    }
    //Por último imprimimos el mayor de los tres números
    printf("El mayor de los tres números es: %d\n", mayor);

    return 0;
}
