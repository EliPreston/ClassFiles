###################
# EXAMPLE: for loops over strings
###################
s = "demo loops"
for index in range(len(s)):
    if s[index] == 'i' or s[index] == 'u':
        print("There is an i or u")

for char in s: #start: s[0]; stop: s[len(s)-1];step=1
    if char == 'i' or char == 'u':
        print("There is an i or u")


###################
# EXAMPLE: while loops and strings
# CHALLENGE: rewrite while loop with a for loop
###################
an_letters = "aefhilmnorsxAEFHILMNORSX"
word = input("I will cheer for you! Enter a word: ")
times = int(input("Enthusiasm level (1-10): "))

i = 0 #initialization of i
while i < len(word): # while condition 
    char = word[i] # translate the ith poisiton to the charater itself
    if char in an_letters:
        print("Give me an " + char + "! " + char)
    else:
        print("Give me a  " + char + "! " + char)
    i += 1 # iteration update
    
print("What does that spell?")

for i in range(times):
    print(word, "!!!")


#The for loop version:
an_letters = "aefhilmnorsxAEFHILMNORSX"
word = input("I will cheer for you! Enter a word: ")
times = int(input("Enthusiasm level (1-10): "))

for char in word: 
#char starts from the start point word[0], stops at the stop point word[len(word)-1] with step =1
    if char in an_letters:
        print("Give me an " + char + "! " + char)
    else:
        print("Give me a  " + char + "! " + char)
        
print("What does that spell?")
for i in range(times):
    print(word, "!!!")
    
####################
## EXERCISE: find the common letter 
####################
s1 = input("Give me your first sentence:")
s2 = input("Give me your second sentence, make sure both sentences are the same length:")

if len(s1) == len(s2):
    for char1 in s1:
        for char2 in s2:
            if char1 == char2:
                print("We get the common letter as:", char1)
                break
else:
    for char1 in s1:
        for char2 in s2:
            if char1 == char2:
                print("We get the common letter as:", char1)
                break
        
s1 = input("Give me your first sentence:")
s2 = input("Give me your second sentence, make sure both sentences are the same length:")
for char1 in s1:
    for char2 in s2: # iterations are decided by the length of s1
        if char1 == char2: # iterations are decided by the length of s2
           print("We get the common letter as:", char1)
           break         
            
s1 = input("Give me your first sentence:")
s2 = input("Give me your second sentence, make sure both sentences are the same length:")       
for char2 in s2:
    for char1 in s1: # iterations are decided by the length of s1
        if char1 == char2: # iterations are decided by the length of s2
           print("We get the common letter as:", char1)
           break    
    
###################
# EXAMPLE: perfect cube 
###################
cube = 27
#cube = 8120601
for guess in range(cube+1):
    if guess**3 == cube:
        print("Cube root of", cube, "is", guess)
        # loops keeps going even after found the cube root
    

###################
# EXAMPLE: guess and check cube root 
###################
cube = 27
#cube = 8120601
for guess in range(abs(cube)+1):
    # passed all potential cube roots
    if guess**3 >= abs(cube):
        # no need to keep searching
        break
if guess**3 != abs(cube):
    print(cube, 'is not a perfect cube')
else:
    if cube < 0:
        guess = -guess
    print('Cube root of ' + str(cube) + ' is ' + str(guess))


###################
# EXAMPLE: approximate cube root 
###################
cube = 27
#cube = 8120601
#cube = 10000
epsilon = 0.01
guess = 0.0
increment = 0.1
num_guesses = 0
# look for close enough answer and make sure
# didn't accidentally skip the close enough bound
#for loop 
#for guess in range(int(abs(cube)/increment)):
#    if int(guess*increment)**3 >= abs(cube):
#        # no need to keep searching
#        break
#while loop
while abs(guess**3 - cube) >= epsilon and guess <= abs(cube):
    guess += increment
    num_guesses += 1
print('num_guesses =', num_guesses)
if abs(guess**3 - cube) >= epsilon:
    print('Failed on cube root of', cube, "with these parameters.")
else:
    print(guess, 'is close to the cube root of', cube)


###################
# EXAMPLE: bisection cube root (only positive cubes!)
###################
cube = 27
#cube = 8120601
# won't work with x < 1 because initial upper bound is less than ans
#cube = 0.25
epsilon = 0.01
num_guesses = 0
low = 0
high = cube
guess = (high + low)/2.0
while abs(guess**3 - cube) >= epsilon:
    if guess**3 < cube:
        # look only in upper half search space
        low = guess
    else:
        # look only in lower half search space
        high = guess
    # next guess is halfway in search space
    guess = (high + low)/2.0
    num_guesses += 1
print('num_guesses =', num_guesses)
print(guess, 'is close to the cube root of', cube)
   
###################
# EXAMPLE: bisection cube root (x<1)
###################
cube = 0.001
#cube = 8120601
# won't work with x < 1 because initial upper bound is less than ans
#cube = 0.25
epsilon = 0.01
num_guesses = 0
low = 0
high = 1
guess = (high + low)/2.0
while abs(guess**3 - cube) >= epsilon:
    if guess**3 < cube:
        # look only in upper half search space
        low = guess
    else:
        # look only in lower half search space
        high = guess
    # next guess is halfway in search space
    guess = (high + low)/2.0
    num_guesses += 1
print('num_guesses =', num_guesses)
print(guess, 'is close to the cube root of', cube)

###################
# EXAMPLE: approximate cube root for x<1
###################
cube = 0.001
#cube = 8120601
#cube = 10000
epsilon = 0.0001
guess = 1
increment = 0.01
num_guesses = 0
# look for close enough answer and make sure
# didn't accidentally skip the close enough bound
#for loop 
#for guess in range(int(abs(cube)/increment)):
#    if int(guess*increment)**3 >= abs(cube):
#        # no need to keep searching
#        break
#while loop
while abs(guess**3 - cube) >= epsilon and guess <= 1:
    guess = guess - increment
    num_guesses += 1
print('num_guesses =', num_guesses)
if abs(guess**3 - cube) >= epsilon:
    print('Failed on cube root of', cube, "with these parameters.")
else:
    print(guess, 'is close to the cube root of', cube)
