import math

n = int(input("Enter a number: "))

if n <= 1:
    print(f"{n} is not a Prime")
else:
    i = 2
    while i <= math.sqrt(n):
        if n % i == 0:
            print(f"{n} is not a Prime")
            break
        i += 1
    else:
        print(f"{n} is a Prime")
