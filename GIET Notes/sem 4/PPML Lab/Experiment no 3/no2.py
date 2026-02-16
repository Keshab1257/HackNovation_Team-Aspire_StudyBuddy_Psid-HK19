a = int(input("Enter first number :- "))
b = int(input("Enter second number :- "))
c = int(input("Enter third number :- "))

root1 = ((b)+(((b**2)-(4*a*c))**0.5))/2
root2 = ((b)-(((b**2)-(4*a*c))**0.5))/2

print("The two roots are ", root1, " and ", root2)