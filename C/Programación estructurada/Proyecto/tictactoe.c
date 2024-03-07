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

    printf("Introduce tu movimiento: 5\n\n");

    sleep(5);

    printf("+-------+-------+-------+\n");
    printf("|       |       |       |\n");
    printf("|       |   X   |       |\n");
    printf("|       |       |       |\n");
    printf("+-------+-------+-------+\n");
    printf("|       |       |       |\n");
    printf("|       |       |       |\n");
    printf("|       |       |       |\n");
    printf("+-------+-------+-------+\n");
    printf("|       |       |       |\n");
    printf("|       |       |       |\n");
    printf("|       |       |       |\n");
    printf("+-------+-------+-------+\n\n");

    printf("Introduce tu movimiento: 1\n\n");

    sleep(5);

    printf("+-------+-------+-------+\n");
    printf("|       |       |       |\n");
    printf("|   0   |   X   |       |\n");
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
}

void mostrar_cuadro(){
    

    printf("+-------+-------+-------+");
    printf("|       |       |       |");
    printf("|   %c  |   %c   |   %c   |",m[1][1],m[1][2],m[1][3]);
    printf("|       |       |       |");
    printf("+-------+-------+-------+");
    printf("|       |       |       |");
    printf("|   %d   |   %d   |   %d   |",m[2][1],m[2][2],m[2][3]);
    printf("|       |       |       |");
    printf("+-------+-------+-------+");
    printf("|       |       |       |");
    printf("|   %d   |   %d   |   %d   |",m[3][1],m[3][2],m[3][2]);
    printf("|       |       |       |");
    printf("+-------+-------+-------+");
}

void introducir_movimiento(){

    
    




}



int main () {

    tutorial();






    return 0;
}