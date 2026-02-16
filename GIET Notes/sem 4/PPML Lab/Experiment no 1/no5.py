#to input two integers and swap them using 3rd variable

a = int(input("Enter first number : "))
b = int(input("Enter second number : "))
print("Before swapping : a = ",a, ", b =", b)
temp = a
a = b 
b = temp
print("After swapping : a = ",a, ", b =", b)