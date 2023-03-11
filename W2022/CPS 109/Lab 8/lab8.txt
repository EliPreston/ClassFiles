# Lab 8
# Name: Eli Preston
# Student ID: 501152959


# Recursively add positive integer b to another int a
def addInts(a, b):

    if b == 1:
        return a + 1
    return 1 + addInts(a, b-1)

# Recursively find an approximate to lag base 2 of x (x is positive)
def log2(x):
    
    if x <= 1:
        return 0
    return 1 + log2(x/2)


# Recursively reverse a string
def reverse(sentence):

    if len(sentence) == 1:
        return sentence
    else:
        temp = sentence[0]
        sentence = sentence[1:]
        return reverse(sentence) + temp

# Recursively calculate n^x (n is positive or 0)
def power(x, n):
    global countcalls
    countcalls += 1


    if n == 0:
        return 1
    else:
        return x*power(x, n-1)


'''
Define a global variable, countcalls, and increment it inside the power(x, n) function that you wrote 
for Q4, so that it counts the number of times the power function is called. Show that 
it produces the expected number of calls for power(2, 10) and power(5, 10) and power(5, 0),
each separately.

Done in [if __name__ == "__main__"]
'''

# Recursively calculate n^x more efficiently (n is positive or 0)
def powerHalf(x, n): 
    global countcalls
    countcalls += 1


    if n == 0:
        return 1
    if n % 2:
        return x * powerHalf(x, n - 1)
    else:
        temp = powerHalf(x, n // 2)
        return temp * temp



# Used in question 7 (last question)
def gcContent(sequence):

    seqLetters = {'A': 0, 'C': 0, 'T': 0, 'G': 0}
    for i in sequence:
        seqLetters[i] += 1

    totalCandG = seqLetters['C'] + seqLetters['G']
    return round((totalCandG/len(sequence))*100, 2)
    
# Testing block
if __name__ == "__main__":
    
    print(addInts(-8, 10))
    print(log2(50))
    print(reverse('Who let the dogs out?'))


    # Comment out 2/3 calls here because otherwise the number of calls will be the result of each print operation added together.
    countcalls = 0
    print(power(2, 10), countcalls)
    # print(power(5, 10), countcalls)
    # print(power(5, 0), countcalls)
    '''
    - power(2, 10) calls power function 11 times (powers 10 --> 0)
    - The general number of calls will be n+1 calls
    - This same tracing can be done for power(5, 10) and power(5, 0) and will
    show the correct number of calls (11 calls for power(5, 10) and 1 call for power(5, 0))
    '''

    # Comment out 2/3 calls here because otherwise the number of calls will be the result of each print operation added together
    countcalls = 0
    # print(powerHalf(2, 10), countcalls)
    # print(powerHalf(5, 10), countcalls)
    print(powerHalf(2, 6), countcalls)




    # Question 7 code + function call
    f = open('/Users/eli/Desktop/--/UGRD2022-2023/CPS 109/Lab 8/kdpF.txt') # opens a file for reading
    # f = open('kdpF.txt') # opens a file for reading

    line = f.readline() # reads a single line
    print(line)

    seq = ''
    for line in f:      # reading the rest of the lines
        seq = seq + line
    seq = seq.replace('\n', '') # removing the newline characters
    seq = seq.upper()
    print(seq)

    # Calling the function that returns the percent of the sequence which is either 'G' or 'C'.
    print(f"Percentage of total sequence made up of both G's and C's: {gcContent(seq)}")



    
