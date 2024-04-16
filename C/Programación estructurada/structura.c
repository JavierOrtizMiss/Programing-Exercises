#include <stdio.h>

int main() {

    struct persona {
        int edad;
        char nombre[50];
        char direccion[50];
        int telefono;
    };

    struct persona empleado;

    printf("********* Censo de empleados ************\n");
    
    printf("Escriba su edad: ");
    scanf("%d", &empleado.edad);

    // Limpiar el buffer después de leer un entero
    while (getchar() != '\n');

    printf("Escriba su nombre: ");
    fgets(empleado.nombre, 50, stdin);

    printf("Escriba su direccion: ");
    fgets(empleado.direccion, 50, stdin);

    printf("Escriba su telefono: ");
    scanf("%d", &empleado.telefono);

    printf("Sus datos son:\n");
    printf("Edad: %d\n", empleado.edad);
    printf("Nombre: %s", empleado.nombre);
    printf("Direccion: %s", empleado.direccion);
    printf("Telefono: %d\n", empleado.telefono);

    return 0;
}
