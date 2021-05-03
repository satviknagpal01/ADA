#include <stdio.h>
int main()
{
    int i, c, p, lambda, m;
    printf("enter the numbers you want the random numbers between:\n");
    printf("initial value = ");
    scanf("%d", &c);
    printf("modulo operator = ");
    scanf("%d", &p);
    printf("multiplicative factor = ");
    scanf("%d", &lambda);
    printf("additive factor = ");
    scanf("%d", &m);
    printf("number of values = ");
    scanf("%d", &i);
    printf("The random numbers are : \n");
    for (int j = 0; j < i; j++)
    {
        c = (lambda * c + m) % p;
        printf("%d \n", c);
    }
    return 0;
}