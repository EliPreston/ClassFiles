
caesar_cipher_dict = {
    'u':'a' , 
    'v':'b' ,
    'w':'c' ,
    'x':'d' ,
    'y':'e' ,
    'z':'f' ,
    'a':'g' ,
    'b':'h' ,
    'c':'i' ,
    'd':'j' ,
    'e':'k' ,
    'f':'l' ,
    'g':'m' ,
    'h':'n' ,
    'i':'o' ,
    'j':'p' ,
    'k':'q' ,
    'l':'r' ,
    'm':'s' ,
    'n':'t' ,
    'o':'u' ,
    'p':'v' ,
    'q':'w' ,
    'r':'x' ,
    's':'y' ,
    't':'z'
    }


f = open("/Users/eli/Desktop/--/UGRD2022-2023/CPS 109/Lab 7/seceret_code.txt", 'r')


decoded = ""
message = ""

for line in f:
    # print(line[0])
    # print(line)

    newLine = ""
    upperFirst = True
    index = 0

    for char in line:

        upper = False
        if char.isupper():
            upper = True
            char = char.lower()
            if index != 0:
                message += char

        index += 1
        if char in caesar_cipher_dict:
            newChar = caesar_cipher_dict[char]

            if upper and upperFirst:
                newLine += newChar.upper()
                upperFirst = False

            else:
                newLine += newChar

        else:
            newLine += char

    decoded += newLine

print(decoded)

m2 = ""
for i in message:
    if i in caesar_cipher_dict:
        newChar = caesar_cipher_dict[i]
        m2 += newChar.upper()

print(m2)

f.close()

output = open('/Users/eli/Desktop/--/UGRD2022-2023/CPS 109/Lab 7/answer.txt', 'w')

output.write(m2)
output.close()