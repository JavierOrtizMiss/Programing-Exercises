#include <stdio.h>

int correctos = 0; // Contador de respuestas correctas
int incorrectos = 0; // Contador de respuestas incorrectas

// Función para sumar dos números
void suma() {
    int num1, num2, resultado, respuesta;

    printf("Ingrese el primer número: ");
    scanf("%d", &num1);
    printf("Ingrese el segundo número: ");
    scanf("%d", &num2);

    resultado = num1 + num2;

    printf("¿Cuál es el resultado de %d + %d? ", num1, num2);
    scanf("%d", &respuesta);

    if (respuesta == resultado) {
        printf("Correcto mi estimado\n");
        correctos++; // Incrementar contador de respuestas correctas
    } else {
        printf("Incorrecto mi chavo. El resultado es %d.\n", resultado);
        incorrectos++; // Incrementar contador de respuestas incorrectas
    }
}

// Función para restar dos números
void resta() {
    int num1, num2, resultado, respuesta;

    printf("Ingrese el primer número: ");
    scanf("%d", &num1);
    printf("Ingrese el segundo número: ");
    scanf("%d", &num2);

    resultado = num1 - num2;

    printf("¿Cuál es el resultado de %d - %d? ", num1, num2);
    scanf("%d", &respuesta);

    if (respuesta == resultado) {
        printf("Correcto mi estimado\n");
        correctos++; // Incrementar contador de respuestas correctas
    } else {
        printf("Incorrecto mi chavo. El resultado es %d.\n", resultado);
        incorrectos++; // Incrementar contador de respuestas incorrectas
    }
}

// Función para multiplicar dos números
void multiplicacion() {
    int num1, num2, resultado, respuesta;

    printf("Ingrese el primer número: ");
    scanf("%d", &num1);
    printf("Ingrese el segundo número: ");
    scanf("%d", &num2);

    resultado = num1 * num2;

    printf("¿Cuál es el resultado de %d * %d? ", num1, num2);
    scanf("%d", &respuesta);

    if (respuesta == resultado) {
        printf("Correcto mi estimado\n");
        correctos++; // Incrementar contador de respuestas correctas
    } else {
        printf("Incorrecto mi chavo. El resultado es %d.\n", resultado);
        incorrectos++; // Incrementar contador de respuestas incorrectas
    }
}

// Función para dividir dos números
void division() {
    int num1, num2, resultado, respuesta;

    printf("Ingrese el primer número: ");
    scanf("%d", &num1);
    printf("Ingrese el segundo número: ");
    scanf("%d", &num2);

    resultado = num1 / num2;

    printf("¿Cuál es el resultado de %d / %d? ", num1, num2);
    scanf("%d", &respuesta);

    if (respuesta == resultado) {
        printf("Correcto mi estimado\n");
        correctos++; // Incrementar contador de respuestas correctas
    } else {
        printf("Incorrecto mi chavo. El resultado es %d.\n", resultado);
        incorrectos++; // Incrementar contador de respuestas incorrectas
    }
}

int main() {
    int opcion = -1;

    printf("\nTe puedo ayudar a:\n");
    printf("1. Sumar\n");
    printf("2. Restar\n");
    printf("3. Multiplicar\n");
    printf("4. Dividir\n");
    printf("5. Resultados\n");
    printf("0. Fin\n");

    while (opcion != 0) {
        printf("Opción: ");
        scanf("%d", &opcion);

        switch (opcion) {
            case 1:
                suma();
                break;
            case 2:
                resta();
                break;
            case 3:
                multiplicacion();
                break;
            case 4:
                division();
                break;
            case 5:
                printf("Respuestas correctas: %d\n", correctos);
                printf("Respuestas incorrectas: %d\n", incorrectos);
                break;
            case 0:
                printf("Vuelve pronto chavo\n");
                break;
            default:
                printf("Opción no válida. Por favor, seleccione una opción que sea válida.\n");
        }
    }

    return 0;
}
