#include <stdio.h> //Librería standard
#include <unistd.h> //Librería para sleep
int m[3][3];

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
          "Cada número del 1 al 9 representa un cuadro del tablero. Por ejemplo:\n\n");

    sleep(5);

    printf("+-------+-------+-------+\n");
    printf("|       |       |       |\n");
    printf("|       |       |       |\n");
    printf("|       |       |       |\n");
    printf("+-------+-------+-------+\n");
    printf("|       |       |       |\n");
    printf("|       |       |       |\n");
    printf("|       |       |       |\n");
    printf("+-------+-------+-------+\n");
    printf("|       |       |       |\n");
    printf("|       |       |       |\n");
    printf("|       |       |       |\n");
    printf("+-------+-------+-------+\n");

    printf("\n");

    sleep(3);

    printf("Introduce tu movimiento: 5\n\n");

    sleep(1);

    printf("\n");

    printf("+-------+-------+-------+\n");
    printf("|       |       |       |\n");
    printf("|       |       |       |\n");
    printf("|       |       |       |\n");
    printf("+-------+-------+-------+\n");
    printf("|       |       |       |\n");
    printf("|       |   X   |       |\n");
    printf("|       |       |       |\n");
    printf("+-------+-------+-------+\n");
    printf("|       |       |       |\n");
    printf("|       |       |       |\n");
    printf("|       |       |       |\n");
    printf("+-------+-------+-------+\n\n");

    sleep(3);

    printf("Introduce tu movimiento: 1\n\n");

    sleep(1);

    printf("\n");

    printf("+-------+-------+-------+\n");
    printf("|       |       |       |\n");
    printf("|   0   |       |       |\n");
    printf("|       |       |       |\n");
    printf("+-------+-------+-------+\n");
    printf("|       |       |       |\n");
    printf("|       |   X   |       |\n");
    printf("|       |       |       |\n");
    printf("+-------+-------+-------+\n");
    printf("|       |       |       |\n");
    printf("|       |       |       |\n");
    printf("|       |       |       |\n");
    printf("+-------+-------+-------+\n");

    sleep(3);

    printf("Introduce tu movimiento: 7\n\n");

    sleep(1);

    printf("\n");

    printf("+-------+-------+-------+\n");
    printf("|       |       |       |\n");
    printf("|   0   |       |       |\n");
    printf("|       |       |       |\n");
    printf("+-------+-------+-------+\n");
    printf("|       |       |       |\n");
    printf("|       |   X   |       |\n");
    printf("|       |       |       |\n");
    printf("+-------+-------+-------+\n");
    printf("|       |       |       |\n");
    printf("|   X   |       |       |\n");
    printf("|       |       |       |\n");
    printf("+-------+-------+-------+\n");

    sleep(3);

    printf("Introduce tu movimiento: 2\n\n");

    sleep(1);

    printf("\n");


    printf("+-------+-------+-------+\n");
    printf("|       |       |       |\n");
    printf("|   0   |   0   |       |\n");
    printf("|       |       |       |\n");
    printf("+-------+-------+-------+\n");
    printf("|       |       |       |\n");
    printf("|       |   X   |       |\n");
    printf("|       |       |       |\n");
    printf("+-------+-------+-------+\n");
    printf("|       |       |       |\n");
    printf("|   X   |       |       |\n");
    printf("|       |       |       |\n");
    printf("+-------+-------+-------+\n");

    sleep(3);

    printf("Introduce tu movimiento: 3\n\n");

    sleep(1);

    printf("\n");


    printf("+-------+-------+-------+\n");
    printf("|       |       |       |\n");
    printf("|   0   |   0   |   X   |\n");
    printf("|       |       |       |\n");
    printf("+-------+-------+-------+\n");
    printf("|       |       |       |\n");
    printf("|       |   X   |       |\n");
    printf("|       |       |       |\n");
    printf("+-------+-------+-------+\n");
    printf("|       |       |       |\n");
    printf("|   X   |       |       |\n");
    printf("|       |       |       |\n");
    printf("+-------+-------+-------+\n");

    printf("!Haz Ganadoo¡\n");
}

void mostrar_cuadro() {
    printf("+-------+-------+-------+\n");
    printf("|       |       |       |\n");
    printf("|   %c   |   %c   |   %c   |\n", m[0][0], m[0][1], m[0][2]);
    printf("|       |       |       |\n");
    printf("+-------+-------+-------+\n");
    printf("|       |       |       |\n");
    printf("|   %c   |   %c   |   %c   |\n", m[1][0], m[1][1], m[1][2]);
    printf("|       |       |       |\n");
    printf("+-------+-------+-------+\n");
    printf("|       |       |       |\n");
    printf("|   %c   |   %c   |   %c   |\n", m[2][0], m[2][1], m[2][2]);
    printf("|       |       |       |\n");
    printf("+-------+-------+-------+\n");
}

void introducir_movimiento(int jugador) {
    int movimiento;
    if (jugador == 1)
        printf("Introduce tu movimiento: ");
    else
        printf("Turno de la máquina...\n");

    scanf("%d", &movimiento);

    int fila = (movimiento - 1) / 3;
    int columna = (movimiento - 1) % 3;

    if (m[fila][columna] == ' ') {
        if (jugador == 1)
            m[fila][columna] = 'X';
        else
            m[fila][columna] = 'O';
    } else {
        printf("¡Movimiento inválido! Por favor, elige una casilla vacía.\n");
        introducir_movimiento(jugador);
    }
}

int verificar_ganador() {
    // Verificar filas y columnas
    for (int i = 0; i < 3; ++i) {
        if (m[i][0] == m[i][1] && m[i][1] == m[i][2] && m[i][0] != ' ')
            return 1; // Jugador 1 gana
        if (m[0][i] == m[1][i] && m[1][i] == m[2][i] && m[0][i] != ' ')
            return 1; // Jugador 1 gana
        if (m[i][0] == m[i][1] && m[i][1] == m[i][2] && m[i][0] != ' ')
            return 2; // Jugador 2 (máquina) gana
        if (m[0][i] == m[1][i] && m[1][i] == m[2][i] && m[0][i] != ' ')
            return 2; // Jugador 2 (máquina) gana
    }
    // Verificar diagonales
    if ((m[0][0] == m[1][1] && m[1][1] == m[2][2]) || (m[0][2] == m[1][1] && m[1][1] == m[2][0])) {
        if (m[1][1] == 'X')
            return 1; // Jugador 1 gana
        else if (m[1][1] == 'O')
            return 2; // Jugador 2 (máquina) gana
    }

    // Verificar empate
    for (int i = 0; i < 3; ++i)
        for (int j = 0; j < 3; ++j)
            if (m[i][j] == ' ')
                return -1; // Todavía hay casillas vacías

    return 0; // Empate
}

int main() {
    int opcion;
    printf("¿Quieres ver el tutorial o jugar directamente?\n");
    printf("1. Ver el tutorial\n");
    printf("2. Jugar\n");
    scanf("%d", &opcion);

    if (opcion == 1) {
        tutorial();
    }

    for (int i = 0; i < 3; ++i)
        for (int j = 0; j < 3; ++j)
            m[i][j] = ' ';

    mostrar_cuadro();
    int turno = 1;
    int ganador = 0;

    while (ganador == 0) {
        introducir_movimiento(turno);
        mostrar_cuadro();
        ganador = verificar_ganador();

        if (ganador != 0)
            break;

        if (turno == 1)
            turno = 2;
        else
            turno = 1;
    }

    if (ganador == -1)
        printf("¡Empate!\n");
    else if (ganador == 1)
        printf("¡Jugador 1 (tú) ganas!\n");
    else if (ganador == 2)
        printf("¡La máquina gana!\n");

    return 0;
}