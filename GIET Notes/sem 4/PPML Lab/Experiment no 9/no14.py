from functools import reduce
n = [1,2,3,4,5]
total = reduce(lambda x,y : x+y, n)
print(total)