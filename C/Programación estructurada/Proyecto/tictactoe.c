#include <stdio.h> //Librería standard
#include <unistd.h> //Librería para sleep
int m[3][3];

void tutorial(){

    printf("---------BIENVENIDO A TIC TAC TOE---------")

    printf("Tic Tac Toe, también conocido como tres en raya, es un juego de mesa para dos jugadores que se juega en una cuadrícula de 3x3. El objetivo del juego es colocar tres fichas del mismo tipo en línea, ya sea horizontal, vertical o diagonalmente, antes que el oponente. Cada jugador alterna colocando sus fichas en las casillas vacías hasta que uno de los jugadores logra formar una línea de tres fichas o se llena el tablero, resultando en un empate. ");

    printf("+-------+-------+-------+");
    printf("|       |       |       |");
    printf("|   1   |   2   |   3   |");
    printf("|       |       |       |");
    printf("+-------+-------+-------+");
    printf("|       |       |       |");
    printf("|   4   |   5   |   6   |");
    printf("|       |       |       |");
    printf("+-------+-------+-------+");
    printf("|       |       |       |");
    printf("|   7   |   8   |   9   |");
    printf("|       |       |       |");
    printf("+-------+-------+-------+");



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






    return 0;
}