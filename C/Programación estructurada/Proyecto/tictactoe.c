#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <ctype.h> // Para la función isdigit

char m[3][3]; // Matriz para el tablero de juego
int puntajes[2] = {0}; // Array para los puntajes de los jugadores
char nombres[2][50]; // Array para los nombres de los jugadores

void tutorial() {
    printf("---------BIENVENIDO A TIC TAC TOE---------\n\n");

    printf("Tic Tac Toe, también conocido como tres en raya, es un juego para dos\n"
           "jugadores que se juega en una cuadrícula de 3x3. El objetivo del juego es colocar tres\n"
           "fichas del mismo tipo en línea, ya sea horizontal, vertical o diagonalmente, antes que el oponente.\n"
           "Cada jugador alterna colocando sus fichas en las casillas vacías hasta que uno de los jugadores logra\n"
           "formar una línea de tres fichas o se llena el tablero, resultando en un empate.\n\n");

    sleep(4);

    printf("Un ejemplo de la cuadrícula es la siguiente:\n\n");

    sleep(5);

    printf("+-------+-------+-------+\n");
    printf("|       |       |       |\n");
    printf("|   1   |   2   |   3   |\n");
    printf("|       |       |       |\n");
    printf("+-------+-------+-------+\n");
    printf("|       |       |       |\n");
    printf("|   4   |   5   |   6   |\n");
    printf("|       |       |       |\n");
    printf("+-------+-------+-------+\n");
    printf("|       |       |       |\n");
    printf("|   7   |   8   |   9   |\n");
    printf("|       |       |       |\n");
    printf("+-------+-------+-------+\n\n");

    sleep(5);

    printf("Para realizar un movimiento, simplemente introduce el número correspondiente al cuadro donde deseas colocar tu ficha. \n"
           "Cada número del 1 al 9 representa un cuadro del tablero.\n\n");

    sleep(5);

    printf("¡Que disfrutes jugando!\n\n");
}

void mostrar_cuadro() {
    printf("+-------+-------+-------+\n");
    printf("|       |       |       |\n");
    printf("|  %c    |  %c    |  %c    |\n", m[0][0], m[0][1], m[0][2]);
    printf("|       |       |       |\n");
    printf("+-------+-------+-------+\n");
    printf("|       |       |       |\n");
    printf("|  %c    |  %c    |  %c    |\n", m[1][0], m[1][1], m[1][2]);
    printf("|       |       |       |\n");
    printf("+-------+-------+-------+\n");
    printf("|       |       |       |\n");
    printf("|  %c    |  %c    |  %c    |\n", m[2][0], m[2][1], m[2][2]);
    printf("|       |       |       |\n");
    printf("+-------+-------+-------+\n\n");
}

int verificar_ganador(char jugador) {
    // Verificar si ganó en líneas
    for (int i = 0; i < 3; i++) {
        if ((m[i][0] == jugador && m[i][1] == jugador && m[i][2] == jugador) ||
            (m[0][i] == jugador && m[1][i] == jugador && m[2][i] == jugador)) {
            return 1;
        }
    }

    // Verificar si ganó en diagonal
    if ((m[0][0] == jugador && m[1][1] == jugador && m[2][2] == jugador) ||
        (m[0][2] == jugador && m[1][1] == jugador && m[2][0] == jugador)) {
        return 1;
    }
    return 0; // No ha ganado
}

int tablero_lleno() {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (m[i][j] == ' ') {
                return 0; // El tablero no está lleno
            }
        }
    }
    return 1; // El tablero está lleno
}

void juegodos() {
    int jugador1, jugador2;
    char respuesta;
    int valid_input; // Variable para verificar la entrada válida

    printf("¡Que empiece el juego!\n");
    printf("Jugador 1 es X y jugador 2 es O\n");

    printf("Ingrese el nombre del Jugador 1: ");
    scanf("%s", nombres[0]);
    printf("Ingrese el nombre del Jugador 2: ");
    scanf("%s", nombres[1]);

    do {
        // Inicializar el tablero
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                m[i][j] = ' ';
            }
        }

        do {
            mostrar_cuadro();
            valid_input = 0; // Inicializar la variable a 0
            printf("%s introduce tu movimiento: ", nombres[0]);
            if (scanf("%d", &jugador1) == 1 && jugador1 > 0 && jugador1 < 10) {
                valid_input = 1; // La entrada es válida
                m[(jugador1 - 1) / 3][(jugador1 - 1) % 3] = 'X';
                if (verificar_ganador('X')) {
                    mostrar_cuadro();
                    printf("¡Felicidades! %s ha ganado.\n", nombres[0]);
                    puntajes[0] += 20;
                    break;
                }

                if (tablero_lleno()) {
                    printf("El tablero está lleno. ¡Es un empate!\n");
                    break;
                }
            } else {
                printf("Por favor, introduzca un número válido\n");
                // Limpiar el búfer de entrada
                while (getchar() != '\n');
            }

            if (valid_input) {
                mostrar_cuadro();
                valid_input = 0; // Reiniciar la variable a 0
                printf("%s introduce tu movimiento: ", nombres[1]);
                if (scanf("%d", &jugador2) == 1 && jugador2 > 0 && jugador2 < 10) {
                    valid_input = 1; // La entrada es válida
                    m[(jugador2 - 1) / 3][(jugador2 - 1) % 3] = 'O';
                    if (verificar_ganador('O')) {
                        mostrar_cuadro();
                        printf("¡Felicidades! %s ha ganado.\n", nombres[1]);
                        puntajes[1] += 20;
                        break;
                    }

                    if (tablero_lleno()) {
                        printf("El tablero está lleno. ¡Es un empate!\n");
                        break;
                    }
                } else {
                    printf("Por favor, introduzca un número válido\n");
                    // Limpiar el búfer de entrada
                    while (getchar() != '\n');
                }
            }

        } while (1);

        printf("¿Deseas jugar de nuevo? (s/n): ");
        scanf(" %c", &respuesta);
    } while (respuesta == 's');
}

void ver_puntajes() {
    printf("Puntaje actual:\n");
    for (int i = 0; i < 2; i++) {
        printf("%s: %d puntos\n", nombres[i], puntajes[i]);
    }
}

int main() {
    int opcion = -1;

    printf("---------BIENVENIDO A TIC TAC TOE---------\n\n");

    while (opcion != 0) {
        printf("Seleccione una opción:\n\n");
        printf("1. Ver tutorial\n"
               "2. Jugar con otro jugador\n"
               "3. Ver puntajes\n"
               "0. Salir\n\n");
        printf("Opción: ");
        scanf("%d", &opcion);

        switch (opcion) {
            case 1:
                tutorial();
                break;
            case 2:
                juegodos();
                break;
            case 3:
                ver_puntajes();
                break;
            case 0:
                printf("------EL JUEGO HA FINALIZADO----\n");
                break;
            default:
                printf("Opción no válida. Por favor, seleccione una opción válida.\n");
        }
    }

    return 0;
}
