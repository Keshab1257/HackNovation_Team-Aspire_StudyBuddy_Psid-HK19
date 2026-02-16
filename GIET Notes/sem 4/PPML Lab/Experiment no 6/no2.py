d = {}
n = int(input("Enter number of key-value pairs :- "))
for i in range(n):
    k = input("Enter key :- ")
    v = input("Enter value :- ")
    d[k] = v

rev = {}

for k, v in d.items():
    rev[v] = k

print("\nOriginal Dictionary :- ")
print(d)

print("\nReversed Dictionary (values as keys) :-")
print(rev)
