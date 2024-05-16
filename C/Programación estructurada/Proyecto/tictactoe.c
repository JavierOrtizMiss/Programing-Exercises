#include <stdio.h>
#include <unistd.h>
#include <ctype.h>
#include <string.h>

char m[3][3]; // Matriz para el tablero de juego
char ganadores[10][50]; // Arreglo para almacenar los nombres de los jugadores ganadores
int puntajes[10]; // Arreglo para almacenar los puntajes de los jugadores
int num_ganadores = 0; // Contador de ganadores

void tutorial() {
    printf("---------BIENVENIDO A TIC TAC TOE---------\n\n");

    printf("Tic Tac Toe, también conocido como tres en raya, es un juego para dos\n"
           "jugadores que se juega en una cuadrícula de 3x3. El objetivo del juego es colocar tres\n"
           "fichas del mismo tipo en línea, ya sea horizontal, vertical o diagonalmente, antes que el oponente.\n"
           "Cada jugador alterna colocando sus fichas en las casillas vacías hasta que uno de los jugadores logra\n"
           "formar una línea de tres fichas o se llena el tablero, resultando en un empate.\n\n");

    sleep(10);

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
    // Verificar si todas las casillas están ocupadas
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (m[i][j] == ' ') {
                return 0; // El tablero no está lleno
            }
        }
    }
    return 1; // El tablero está lleno
}

void juegodos(){
    int jugador;
    char respuesta;
    char turno = 'X'; // Iniciamos con el turno del jugador X

    printf("¡Que empiece el juego!\n");
    printf("Jugador 1 es X y jugador 2 es O\n");

    do {
        // Inicializar el tablero
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                m[i][j] = ' ';
            }
        }

        do {
            mostrar_cuadro();
            printf("Jugador %c introduce tu movimiento (1-9): ", turno);
            char input[10];
            scanf("%s", input);

            // Verificar si el input contiene solo un carácter y si ese carácter es un número del 1 al 9
            if (strlen(input) != 1 || input[0] < '1' || input[0] > '9') {
                printf("Entrada no válida. Por favor, introduce un número del 1 al 9.\n");
                continue;
            }

            jugador = input[0] - '0'; 

            // Verificar si la casilla está ocupada
            if (m[(jugador - 1) / 3][(jugador - 1) % 3] != ' ') {
                printf("La casilla está ocupada. Por favor, elige otra.\n");
                continue;
            }

            // Actualizar tablero
            m[(jugador - 1) / 3][(jugador - 1) % 3] = turno;
            if (verificar_ganador(turno)) {
                mostrar_cuadro();
                printf("¡Felicidades! Jugador %c ha ganado.\n", turno);
                printf("Introduzca el nombre del ganador: ");
                char nombre[50];
                scanf("%s", nombre);

                int repetido = 0;
                for (int i = 0; i < num_ganadores; i++) {
                    if (strcmp(nombre, ganadores[i]) == 0) {
                        puntajes[i] += 20;
                        printf("Puntaje de %s aumentado a %d\n", nombre, puntajes[i]);
                        repetido = 1;
                        break;
                    }
                }

                if (!repetido) {
                    strcpy(ganadores[num_ganadores], nombre);
                    puntajes[num_ganadores] = 20;
                    num_ganadores++;
                }

                break;
            }

            if (tablero_lleno()) {
                printf("El tablero está lleno. ¡Es un empate!\n");
                break;
            }

            turno = (turno == 'X') ? 'O' : 'X'; // Cambiamos el turno
        } while (1);

        printf("¿Deseas jugar de nuevo? (s/n): ");
        scanf(" %c", &respuesta);
    } while (respuesta == 's');
}

void verpuntajes(){
    printf("Lista de jugadores ganadores y sus puntajes:\n");
    for (int i = 0; i < num_ganadores; i++) {
        printf("Jugador: %s - Puntos: %d\n", ganadores[i], puntajes[i]);
    }
}

int main() {
    int opcion = -1;

    printf("---------BIENVENIDO A TIC TAC TOE---------\n\n");
    printf("--> RECUERDE QUE PARA JUGAR ESTE JUEGO SE NECESITAN DOS PERSONAS <--\n\n");

    while (opcion != 0) {
        printf("Seleccione una opción:\n\n");
        printf("1. Ver tutorial\n"
               "2. Jugar\n"
               "3. Lista de puntajes\n"
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
                verpuntajes();
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
