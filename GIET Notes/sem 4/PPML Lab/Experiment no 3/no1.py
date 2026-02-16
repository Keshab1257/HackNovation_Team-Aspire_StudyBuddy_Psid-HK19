#test a string is palindrome or not

n = input("Enter a string :- ")
if(n == n[::-1]):
    print(f"{n} is a  palindrome")
else :
    print(f"{n} is not a palindrome")
