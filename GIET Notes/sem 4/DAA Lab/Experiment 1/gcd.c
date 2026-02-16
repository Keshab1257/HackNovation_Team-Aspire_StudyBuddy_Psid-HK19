#include<stdio.h>

int recoGCD(int a, int b){
    return (b == 0)? a : recoGCD(b, a%b);
}

int main(){
    int x, y;
    printf("Enter two numbers:- ");
    scanf("%d %d", &x, &y);
    printf("GCD = %d", recoGCD(x, y));
    return 0;
}