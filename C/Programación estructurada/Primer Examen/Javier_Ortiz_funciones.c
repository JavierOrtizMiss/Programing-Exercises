//Ortiz Miss Javier de Jesus

#include <stdio.h>

void ciclofor(){
    int n,i,sumatoria;
    printf("---Introduzca un número n positivo---\n");
    scanf("%d",&n);

    if (n<0)
    {
        printf("Introduzca número positivo porfavor (-_-) \n");
        return;
    } else {
        sumatoria=0;
        for (i = 1; i<=n; i++)
        {
            sumatoria+=i;
        }
        printf("La sumatoria es: %d\n", sumatoria);
        
    }
}
void ciclowhile(){
    int n,i,sumatoria;
    printf("---Introduzca un número n positivo---\n");
    scanf("%d",&n);

    if (n<0)
    {
        printf("Introduzca número positivo porfavor (-_-) \n");
        return;
    } else {
        sumatoria=0;
        i=1;

        while (i<=n)
        {
            sumatoria+=i;
            i++;
        }

        printf("La sumatoria es: %d\n", sumatoria);
    } 
}

void ciclodowhile(){
    int n,i,sumatoria;
    printf("---Introduzca un número n positivo---\n");
    scanf("%d",&n);

    if (n<0)
    {
        printf("Introduzca número positivo porfavor (-_-) \n");
        return;
    } else {
        sumatoria=0;
        i=1;

        do
        {
            sumatoria+=i;
            i++;
        } while (i<=n);
        printf("La sumatoria es: %d\n", sumatoria);
    }    
}

int main(){
    int numero;
    int opcion = -1;

    printf("\nIntroduzca el ciclo que desea calcular:\n");
    printf("1. Ciclo For\n");
    printf("2. Ciclo while\n");
    printf("3. Ciclo do-while\n");
    printf("0. Terminar programa\n");

    while (opcion != 0) {
        printf("Opción: ");
        scanf("%d", &opcion);

        switch (opcion) {
            case 1:
                ciclofor();
                break;
            case 2:
                ciclowhile();
                break;
            case 3:
                ciclodowhile();
                break;
            case 0:
                printf("------EL PROGRAMA HA FINALIZADO----");
                break;
            default:
                printf("Opción no válida. Por favor, seleccione una opción que sea válida.\n");
        }
    }
    return 0;
}