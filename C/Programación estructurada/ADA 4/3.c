//Ortiz Miss Javier de Jesus

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Estructura para almacenar los datos de una persona
struct Persona {
    char nombre[50];
    int edad;
    char direccion[100];
    char telefono[15];
};

// Función para insertar una persona en la lista
void insertar(struct Persona *lista, int *numPersonas) {
    if (*numPersonas >= 10) {
        printf("La lista está llena. No se pueden agregar más personas.\n");
        return;
    }

    printf("Ingrese el nombre: ");
    scanf("%s", lista[*numPersonas].nombre);
    printf("Ingrese la edad: ");
    scanf("%d", &lista[*numPersonas].edad);
    printf("Ingrese la dirección: ");
    scanf("%s", lista[*numPersonas].direccion);
    printf("Ingrese el teléfono: ");
    scanf("%s", lista[*numPersonas].telefono);

    (*numPersonas)++;
    printf("Persona agregada correctamente.\n");
}

// Función para borrar una persona de la lista
void borrar(struct Persona *lista, int *numPersonas) {
    if (*numPersonas == 0) {
        printf("La lista está vacía. No hay personas para borrar.\n");
        return;
    }

    int indice;
    printf("Ingrese el índice de la persona a borrar (0-%d): ", *numPersonas - 1);
    scanf("%d", &indice);

    if (indice < 0 || indice >= *numPersonas) {
        printf("Índice inválido. Debe estar entre 0 y %d.\n", *numPersonas - 1);
        return;
    }

    // Mover las personas siguientes una posición hacia atrás
    for (int i = indice; i < *numPersonas - 1; i++) {
        lista[i] = lista[i + 1];
    }

    (*numPersonas)--;
    printf("Persona borrada correctamente.\n");
}

// Función para imprimir la lista de personas
void imprimir(struct Persona *lista, int numPersonas) {
    if (numPersonas == 0) {
        printf("La lista está vacía. No hay personas para mostrar.\n");
        return;
    }

    printf("Lista de personas:\n");
    for (int i = 0; i < numPersonas; i++) {
        printf("Persona %d:\n", i + 1);
        printf("Nombre: %s\n", lista[i].nombre);
        printf("Edad: %d\n", lista[i].edad);
        printf("Dirección: %s\n", lista[i].direccion);
        printf("Teléfono: %s\n", lista[i].telefono);
        printf("\n");
    }
}

int main() {
    struct Persona listaPersonas[10];
    int numPersonas = 0;
    int opcion;

    while (1) {
        printf("\nMenú:\n");
        printf("1. Insertar persona\n");
        printf("2. Borrar persona\n");
        printf("3. Imprimir lista\n");
        printf("4. Salir\n");
        printf("Seleccione una opción: ");
        scanf("%d", &opcion);

        switch (opcion) {
            case 1:
                insertar(listaPersonas, &numPersonas);
                break;
            case 2:
                borrar(listaPersonas, &numPersonas);
                break;
            case 3:
                imprimir(listaPersonas, numPersonas);
                break;
            case 4:
                printf("¡Hasta luego!\n");
                return 0;
            default:
                printf("Opción inválida. Intente nuevamente.\n");
        }
    }

    return 0;
}
