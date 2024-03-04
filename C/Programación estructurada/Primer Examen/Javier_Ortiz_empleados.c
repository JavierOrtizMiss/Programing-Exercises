//Ortiz Miss Javier de Jesus

#include <stdio.h>
#include <math.h>
int main() {
    int trabajadores, salariototal, horastrabajadas, tarifaporhora, sumador;
    int i;
    float sueldo,sueldototal;

    i=1;
    sumador=0;

    while (i==1)
    {
        printf("Introduzca la tarifa por hora: \n");
        scanf("%d",&tarifaporhora);
        printf("Introduzca las horas trabajadas: \n");
        scanf("%d", &horastrabajadas);

        sueldo=horastrabajadas*tarifaporhora;
        sueldototal=(sueldo*1.15)-(sueldo*0.06);


        printf("--Salario Bruto--\n");
        printf("%f\n",round(sueldo));
        printf("--Salario con percepciones y deducciones--\n");
        printf("%f\n",round(sueldototal));

        sumador+=sueldototal;

        printf("Presione (1) para continuar, de lo contrario finaliza el programa\n");
        scanf("%d",&i);
    }

    printf("El total pagado de la empresa es: \n");
    printf("%f",round(sumador));
    return 0;
}
