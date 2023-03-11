




def recursiveTeletubby1(s, teletubby, l):

    if len(s) == 0:
        return l
    else:
        l.append(teletubby)
        newS = s.replace(teletubby, "", 1)
        return recursiveTeletubby1(newS, teletubby, l)
        

def checkTeletubby(s):
    validTeletubbies = ["Tinky Winky", "Dipsy", "Laa-Laa", "Po"]
    l = []

    for i in range(len(validTeletubbies)):
        if validTeletubbies[i][0] == s[0]:
            teletubby = validTeletubbies[i]
            break
    return recursiveTeletubby1(s, teletubby, l)



# LONG SOLUTION, NOT VERY GOOD
# def addToList(x, teletubby, l):

#     if len(l) == x:
#         return l
#     else:
#         l.append(teletubby)
#         addToList(x, teletubby, l)



# def recursiveTeletubby(s):

#     firstLetter = s[0]

#     if firstLetter == 'T':
#         x = s.count("Tinky Winky")
#         teletubby = "Tinky Winky"

#     elif firstLetter == 'D':
#         x = s.count("Dipsy")
#         teletubby = "Dipsy"

#     elif firstLetter == 'L':
#         x = s.count("Laa-Laa")
#         teletubby = "Laa-Laa"

#     elif firstLetter == 'P':
#         x = s.count("Po")
#         teletubby = "Po"

#     l = []
#     addToList(x, teletubby, l)
    
#     return l




if __name__ == "__main__":
    
    print(checkTeletubby('DipsyDipsyDipsyDipsy'))