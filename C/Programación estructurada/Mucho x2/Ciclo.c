#include <stdio.h>
int main() {
    int i, sum;

    sum=0;

    for ( i = 0; i <=40; i++)
    {
        if (i % 2==1) {
            sum=sum+i;
            printf("%d \n", i);
        }
    }
    printf("%d \n", sum);
    


    return 0;
}