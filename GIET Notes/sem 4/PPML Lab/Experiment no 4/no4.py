n = int(input("Enter a positive integer: "))

sum = 0

while n > 0:
    sum += n % 10
    n //= 10

print("Sum of digits:", sum)
