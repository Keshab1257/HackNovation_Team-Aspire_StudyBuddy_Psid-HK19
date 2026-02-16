#write a program to create a list by initializing with 5 different fruits names and display them.

l = []
print("Enter five fruits name :- ")
for i in range(0,5):
    l.append(input())

print("The entered fruits name are :- ", end=" ")
for i in range(0,5):
    print(l[i], end=", ")