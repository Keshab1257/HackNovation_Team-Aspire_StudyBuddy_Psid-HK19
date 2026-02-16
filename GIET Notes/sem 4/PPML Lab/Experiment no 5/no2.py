l = [1,2,3,4,5]
print("Elements in the list are :- ")
for i in l:
    print(i, end=", ")

t = ("Rajesh Rana","24CSEAIML015","24UG010512")
print("\n\nElements in the tuple are :- ")
for i in t:
    print(i, end=", ")

d = {"Name":"Rajesh Rana", "Roll no.":"24CSEAIML015","Regd no.":"24UG010512"}
print("\n\nElements in the dictionary are :- ")
for i in d:
    print(f"{i} : {d[i]}")

s = {1,2,3,4}
print("\nElements in the set are :- ")
for i in s:
    print(i, end=", ")