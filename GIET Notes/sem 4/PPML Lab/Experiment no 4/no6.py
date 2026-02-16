n = int(input("Enter a non-negative integer: "))

if n < 0:
    print("Factorial not defined for negative numbers")
else:
    fact = 1
    i = 1

    while i <= n:
        fact *= i
        i += 1

    print("Factorial:", fact)
