i = input("Enter a sentence :- ")
LIST1 = i.split()

print("\nElements of LIST1 with index :-")
for i, w in enumerate(LIST1):
    print(i, w)

LIST2 = list(range(1, len(LIST1) + 1))

LIST3 = list(zip(LIST1, LIST2))

print("\nCombined LIST3 using zip :-")
print(LIST3)
