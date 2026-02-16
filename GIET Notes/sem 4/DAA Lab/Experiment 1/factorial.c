#include <stdio.h>

int recoFactorial(int a){
    return (a == 0 || a == 1)? 1 : a * recoFactorial(a-1);
}

int main() {
    int a;
    printf("Enter a number: ");
    scanf("%d", &a);

    if (a < 0) {
        printf("Factorial is not defined for negative numbers.");
    } else {
        printf("The factorial of %d is %d", a, recoFactorial(a));
    }

    return 0;
}
