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

    printf("--------FIN DEL TUTORIAL-------\n");
}

void mostrar_cuadro(){
    

    printf("+-------+-------+-------+\n");
    printf("|       |       |       |\n");
    printf("|   %c   |   %c   |   %c   |\n", m[1][1],m[1][2],m[1][3]);
    printf("|       |       |       |\n");
    printf("+-------+-------+-------+\n");
    printf("|       |       |       |\n");
    printf("|   %c   |   %c   |   %c   |\n", m[2][1],m[2][2],m[2][3]);
    printf("|       |       |       |\n");
    printf("+-------+-------+-------+\n");
    printf("|       |       |       |\n");
    printf("|   %c   |   %c   |   %c   |\n", m[3][1],m[3][2],m[3][3]);
    printf("|       |       |       |\n");
    printf("+-------+-------+-------+\n\n");

}

void introducir_movimiento() {

}






int main () {
    int opcion = -1;


    printf("---------BIENVENIDO A TIC TAC TOE---------\n\n");

    while (opcion!=0){
        printf("Seleccioné una opción: \n\n");
        sleep(2);
        printf("1. Ver tutorial\n"
        "2. Jugar con maquina\n"
        "3. Jugar con otro jugador\n\n");
        printf("Opción: ");
        scanf("%d", &opcion);

        switch (opcion)
        {
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 0:
                printf("------EL JUEGO HA FINALIZADO----");
                break;
            default:
                printf("Opción no válida. Por favor, seleccione una opción que sea válida.\n");
        }
    }
    









    return 0;
}