#include<stdio.h>

int recoFibenacci(int a, int b, int c){
    printf("%d, ", a);
    return (c == 0)? 0 : recoFibenacci(b, a+b, c-1); 
}

int main(){
    int a;
    printf("Enter the number of elements to display :- ");
    scanf("%d", &a);
    recoFibenacci(0,1,a-1);
}