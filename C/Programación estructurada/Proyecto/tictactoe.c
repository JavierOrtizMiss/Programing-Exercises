#include <stdio.h>
#include <unistd.h>

char m[3][3]; // Matriz para el tablero de juego

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

void juegodos(){
    int jugador1, jugador2;

    printf("¡Que empiece el juego!\n");
    printf("Jugador 1 es X y jugador 2 es O\n");

    // Inicializar el tablero
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            m[i][j] = ' ';
        }
    }

    do {
        mostrar_cuadro();
        printf("Jugador 1 introduce tu movimiento: ");
        scanf("%d", &jugador1);
        // Actualizar tablero
        m[(jugador1 - 1) / 3][(jugador1 - 1) % 3] = 'X';
        if (verificar_ganador('X')) {
            mostrar_cuadro();
            printf("¡Felicidades! Jugador 1 (X) ha ganado.\n");
            return;
        }

        mostrar_cuadro();
        printf("Jugador 2 introduce tu movimiento: ");
        scanf("%d", &jugador2);
        // Actualizar tablero
        m[(jugador2 - 1) / 3][(jugador2 - 1) % 3] = 'O';
        if (verificar_ganador('O')) {
            mostrar_cuadro();
            printf("¡Felicidades! Jugador 2 (O) ha ganado.\n");
            return;
        }
    } while (1);
}

int main() {
    int opcion = -1;

    printf("---------BIENVENIDO A TIC TAC TOE---------\n\n");

    while (opcion != 0) {
        printf("Seleccione una opción:\n\n");
        printf("1. Ver tutorial\n"
               "2. Jugar con la máquina\n"
               "3. Jugar con otro jugador\n"
               "0. Salir\n\n");
        printf("Opción: ");
        scanf("%d", &opcion);

        switch (opcion) {
            case 1:
                tutorial();
                break;
            case 2:
                //jugarmaquina();
                break;
            case 3:
                juegodos();
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
