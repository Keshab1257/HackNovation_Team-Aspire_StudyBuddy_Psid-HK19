n = int(input("Enter an integer: "))

original = n
reverse = 0

while n > 0:
    digit = n % 10
    reverse = reverse * 10 + digit
    n //= 10

if original == reverse:
    print(f"{original} is a Palindrome")
else:
    print(f"{original} is not a Palindrome")
