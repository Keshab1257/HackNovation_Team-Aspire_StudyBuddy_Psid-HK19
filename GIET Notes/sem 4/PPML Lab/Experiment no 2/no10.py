#to input a string "   hi ram hi shyam hi mam    ". Search the word "hi" and replace it with "hello". Remove the white spaces from the beginning and end and then display the sentence. 

s = "   hi ram hi shyam hi mam    "
s = s.replace("hi","hello")
print("After replacing the 'hi' with 'hello' : ", s)
print("After removing the white space :", s.strip())