#include <stdio.h>
int main() {
    int i, sum;

    sum=0;

    for ( i = 0; i <=20; i++)
    {
        if (i % 2==1) {
            sum=sum+i;
            printf("%d \n", i);
        }
    }
    sum=sum + 2*i+1;
    printf("%d \n", sum);
    


    return 0;
}