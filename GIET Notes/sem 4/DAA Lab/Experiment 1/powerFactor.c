#include<stdio.h>

int recoPower(int a, int b){
    return (b == 1)? a : a * recoPower(a, b-1);
}

int main(){
    int x, y;
    printf("Enter two numbers:- ");
    scanf("%d %d", &x, &y);
    printf("%d^%d is %d", x, y ,((y == 0)? 1 : recoPower(x, y)));
    return 0;
}