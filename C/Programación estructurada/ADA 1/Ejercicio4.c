//Ortiz Miss Javier de Jesus                Ejercicio 4

#include <stdio.h>
#include <math.h>

int main() {
    //Declaramos las variables n y es_primo
    int n;
    int es_primo = 1; // asumimos que es primo hasta que se vea lo contrario


    //Le pedimos al usuario un número y lo guardamos en la función scanf
    printf("Introduzca un número n:");
    scanf("%d", &n);

    //Creamos un ciclo for que empiece en i=2 hasta que i sea <= a la raíz de n
    for (int i = 2; i <= sqrt(n); i++) {
        //Dentro del ciclo encontramos si el numero n es divisible entre algún numero del contador del ciclo
        // y si es así entonces no es primo, porque hay algún otro número que lo divide que no sea si mismo o 1
        if (n % i == 0) {
            es_primo = 0; // si encontramos un divisor, entonces no es primo
            break; // salimos del bucle
        }
    }
    // Como 1 no es primero lo establecemos si en dado caso el usuario lo llegase a poner
    if (n <= 1) {
        es_primo = 0;
    }
    
    //Creamos una condición para que si la variable es_primo==1 entonces es primo
    //sino no es primo y al final lo pedimos
    if (es_primo== 1) {
        printf("%d es primo.\n", n);
    } else {
        printf("%d no es primo.\n", n);
    }

    return 0;
}
