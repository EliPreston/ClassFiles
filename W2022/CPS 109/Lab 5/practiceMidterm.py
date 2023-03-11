
from gettext import find


def findRoot(x):

    guess = 2
    numGuesses = 0
    n = 0

    while (n < 10):
        n += 1
        numGuesses += 1

        print("old guess = ", guess)
        y = (guess+77)/guess
        print(y)
        newGuess = ((guess+x)/guess)/2
        guess = newGuess

        print("new guess = " , newGuess)

    return guess, numGuesses
    

print(findRoot(77))





def largestOdd1(x, y, z):
    print("start")
    if x % 2 == 1:
        print("here1")
        if y % 2 == 1 and x >= y:
            print("here2")
            if z % 2 == 1 and x >= z:
                print(x)
    if y % 2 == 1:
        print("here3")
        if x % 2 == 1 and y >= x:
            print("here4")
            if z % 2 == 1 and x >= z:
                print(y)
    if z % 2 == 1:
        print("here5")
        if x % 2 == 1 and z >= x:
            print("here6")
            if y % 2 == 1 and z >= y:
                print(z)
    else:
        print('All three numbers are even')

# largestOdd1(1, 3, 2)

def smallest(x, y, z):
    if x <= y and x <= z :
        print(x, ' is the least of the three values')
    elif y <= x and y <= z :
        print(y, ' is the least of the three values')
    else:
        print(z, ' is the least of the three values')

# smallest(3, 2, 4)

def largestOdd(x, y, z):
    foundOdd = False
    largest = 0
    if x % 2 == 1 :
        largest = x
        foundOdd = True
    if y % 2 == 1 :
        if not foundOdd :
            largest = y
            foundOdd = True
        elif y > largest :
            largest = y
    if z % 2 == 1 :
        if not foundOdd :
            largest = z
            foundOdd = True
        elif z > largest :
            largest = z
    if foundOdd :
        print('largest odd = ', largest)
    else :
        print('All three were even')

# largestOdd(2, 2, 4)



def sumDigits(s):

    sum = 0
    for i in s:
        sum += int(i)
    return sum

# print(sumDigits('09876543211234567890'))


def divide7not5():

    sum = 0
    for i in range(1, 1001):
        if i % 5 == 0:
            sum += 0
        elif i % 7 == 0:
            sum += i
            print(i)
    return sum


# print(divide7not5())


def binaryToDecimal(l):

    sum = 0
    for i in l:
        bintoDec = int(str(i), 2)
        print(bintoDec)
        sum += bintoDec

    return sum

l = [10100, 101000, 100000, 1011111, 1000, 1010111, 1010010, 11001, 101100, 10111, 11011, 1011010, 11101, 10, 110011, 1001111, 110010, 101100, 100001, 111001]
# print(binaryToDecimal(l))


def sumToN(n):
    sum = 0
    for i in range(1, n+1):
        if n % i == 0:
            sum += i

    return sum

# print(sumToN(4312943))

def sumIndices(s):
    # s = s.lower()
    print(s)
    print(s.lower())
    sum = 0
    alphabet = 'abcdefghijklmnopqrstuvwxyz'
    for i in s:
        # print(i)
        print(alphabet.find(i))
        sum += alphabet.find(i)


    # for i in s:
    #     char = ord(i) - 97
    #     # print(char)
    #     if -1 < char < 26:
    #         sum += char
    #     else:
    #         sum -= 1
    #     print(sum)

    return sum
    


# print(sumIndices("I went to town!"))


def bisectionSearch(n):

    x = 100
    epsilon = 0.01
    guesses = 1
    low = 0
    high = 100
    y = (low + high)/2


 
    while abs(y**4 - x) >= epsilon:
        guesses += 1
        print(abs(y**4 - 100))
        print(low, high, y)

        if y**4 < 100:
            low = y
        elif y**4 > 100:
            high = y
        
        y = (low + high)/2
        
    return guesses, y**4



# print(bisectionSearch(100))