#include <stdio.h>

const int F = 5;
const int C = 3;

// Función para imprimir la matriz de calificaciones
void imprimirMatriz(int matriz[F][C]) {
    printf("Calificaciones:\n");
    printf("Alumno | Examen 1 | Examen 2 | Examen 3\n");
    printf("----------------------------------------\n");
    for (int i = 0; i < F; i++) {
        printf("%d |", i + 1);
        for (int j = 0; j < C; j++) {
            printf("   %d   |", matriz[i][j]);
        }
        printf("\n");
    }
    printf("----------------------------------------\n");
}

// Función para encontrar la calificación más alta y más baja
void encontrarmaxmin(int matriz[F][C]) {
    int maximo = matriz[0][0];
    int minimo = matriz[0][0];
    int fila_max, fila_min, col_max, col_min;

    for (int i = 0; i < F; i++) {
        for (int j = 0; j < C; j++) {
            if (matriz[i][j] > maximo) {
                maximo = matriz[i][j];
                fila_max = i + 1;
                col_max = j + 1;
            }
            if (matriz[i][j] < minimo) {
                minimo = matriz[i][j];
                fila_min = i + 1;
                col_min = j + 1;
            }
        }
    }

    printf("La calificación más alta es %d y pertenece al alumno %d en el Examen %d.\n", maximo, fila_max, col_max);
    printf("La calificación más baja es %d y pertenece al alumno %d en el Examen %d.\n", minimo, fila_min, col_min);
}

// Función para agregar puntos adicionales a una calificación
void agregarPuntos(int matriz[F][C], int alumno, int puntos) {
    if (alumno >= 1 && alumno <= F && puntos <= 10) {
        printf("Se han agregado %d puntos adicionales al alumno %d.\n", puntos, alumno);
        for (int j = 0; j < C; j++) {
            matriz[alumno - 1][j] += puntos;
            if (matriz[alumno - 1][j] > 100) // Verificar que la calificación no exceda de 100
                matriz[alumno - 1][j] = 100;
        }
    } else {
        printf("Número de alumno o puntos inválidos.\n");
    }
}

// Función para calcular el promedio de cada alumno y de cada examen
void calcularPromedios(int matriz[F][C]) {
    float promedio_alumnos[F] = {0};
    float promedio_examenes[C] = {0};

    for (int i = 0; i < F; i++) {
        for (int j = 0; j < C; j++) {
            promedio_alumnos[i] += matriz[i][j];
            promedio_examenes[j] += matriz[i][j];
        }
        promedio_alumnos[i] /= C;
    }

    printf("Promedio de cada alumno:\n");
    for (int i = 0; i < F; i++) {
        printf("Alumno %d: %.2f\n", i + 1, promedio_alumnos[i]);
    }

    printf("\nPromedio de cada examen parcial:\n");
    for (int j = 0; j < C; j++) {
        promedio_examenes[j] /= F;
        printf("Examen %d: %.2f\n", j + 1, promedio_examenes[j]);
    }
}

int main() {
    int calificaciones[F][C];

    // Pedir al usuario que ingrese las calificaciones
    printf("Ingrese las calificaciones de los alumnos:\n");
    for (int i = 0; i < F; i++) {
        printf("Alumno %d:\n", i + 1);
        for (int j = 0; j < C; j++) {
            printf("Examen %d: ", j + 1);
            scanf("%d", &calificaciones[i][j]);
        }
    }

    // 1. Imprimir la matriz de calificaciones
    imprimirMatriz(calificaciones);
    printf("\n");

    // 2. Encontrar la calificación más alta y más baja
    encontrarmaxmin(calificaciones);
    printf("\n");

    // 3. Agregar puntos adicionales a una calificación
    int alumno, puntos;
    printf("Ingrese el número del alumno al que desea agregar puntos adicionales (1-%d): ", F);
    scanf("%d", &alumno);
    printf("Ingrese el número de puntos adicionales (no mayor a 10): ");
    scanf("%d", &puntos);
    agregarPuntos(calificaciones, alumno, puntos);
    printf("\n");

    // 4. Calcular el promedio de cada alumno y de cada examen
    calcularPromedios(calificaciones);

    return 0;
}
