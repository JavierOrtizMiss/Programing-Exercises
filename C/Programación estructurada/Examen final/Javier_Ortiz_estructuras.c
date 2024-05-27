//Ortiz Miss Javier de Jesus
#include <stdio.h>
#include <string.h>

#define MAX_PACIENTES 100

struct Paciente {
    char nombre[50];
    char direccion[100];
    int edad;
    char sexo[20];
    int dia_visita;
    char problema_medico[100];
};

void ingresarDatos(struct Paciente pacientes[], int num_pacientes) {
    if (num_pacientes >= MAX_PACIENTES) {
        printf("Número máximo de pacientes alcanzado (100).\n");
        return;
    }

    printf("Ingrese el nombre del paciente: ");
    scanf(" %[^\n]", pacientes[num_pacientes].nombre);
    

    printf("Ingrese la dirección del paciente: ");
    scanf(" %[^\n]", pacientes[num_pacientes].direccion);
    

    printf("Ingrese la edad del paciente: ");
    scanf("%d", &pacientes[num_pacientes].edad);

    printf("Ingrese el sexo del paciente: ");
    scanf(" %[^\n]", pacientes[num_pacientes].sexo);
    

    printf("Ingrese el día de visita del paciente (1-7): ");
    scanf("%d", &pacientes[num_pacientes].dia_visita);

    if (pacientes[num_pacientes].dia_visita < 1 || pacientes[num_pacientes].dia_visita > 7) {
        printf("Por favor, ingrese un día válido entre 1 y 7.\n");
        return;
    }

    printf("Introduzca el problema médico: ");
    scanf(" %[^\n]", pacientes[num_pacientes].problema_medico);
    
}

void mostrarpacientes(struct Paciente pacientes[], int num_pacientes, int dia) {
    printf("Pacientes que visitan el día %d:\n", dia);
    for (int i = 0; i < num_pacientes; i++) {
        if (pacientes[i].dia_visita == dia) {
            printf("Nombre: %s\n", pacientes[i].nombre);
            printf("Dirección: %s\n", pacientes[i].direccion);
            printf("Edad: %d\n", pacientes[i].edad);
            printf("Sexo: %s\n", pacientes[i].sexo);
            printf("Problema médico: %s\n\n", pacientes[i].problema_medico);
        }
    }
}

int main() {
    struct Paciente pacientes[MAX_PACIENTES];
    int num_pacientes = 0;
    int opcion = -1, dia;

    while (opcion != 0) {
        printf("\n----PACIENTES HOSPITAL-----\n");
        printf("1. Ingrese los datos del paciente.\n");
        printf("2. Mostrar los pacientes por cada día de visita.\n");
        printf("0. Terminar programa.\n");
        printf("Opción: ");
        scanf("%d", &opcion);

        switch (opcion) {
            case 1:
                ingresarDatos(pacientes, num_pacientes);
                num_pacientes++;
                break;
            case 2:
                printf("Ingrese el día de visita (1-7): ");
                scanf("%d", &dia);
                mostrarpacientes(pacientes, num_pacientes, dia);
                break;
            case 0:
                printf("Programa finalizado\n");
                break;
            default:
                printf("Opción no válida.\n");
        }
    }

    return 0;
}
