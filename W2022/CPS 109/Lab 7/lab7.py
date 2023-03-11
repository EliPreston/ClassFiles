# Lab 7
# Name: Eli Preston
# Student ID: 501152959


# ------------------------------------------------------------------- #
# Helper function, returns list of 20 random dice rolls
import random
def diceRolls():

    rolls = []
    for n in range(20):
        roll = random.randint(1,6)
        rolls.append(roll)
    rolls.append('end')
    return rolls

# ------------------------------------------------------------------- #
# Generates a list of 20 dice rolls with the helper function, and
# then marks each run of 2 or more with brackets around them
def sequenceRun(): 

    rolls = diceRolls()

    sequenceRuns = ""
    inRun = False
    for i in range(len(rolls)-1):

        if inRun:
            if rolls[i] != rolls[i-1]:
                sequenceRuns += ')'
                inRun = False
                
        if rolls[i] == rolls[i+1] and (inRun == False):
            sequenceRuns += '('
            inRun = True

        sequenceRuns += str(rolls[i])
    if inRun:
        sequenceRuns += ')'
    return sequenceRuns


# ------------------------------------------------------------------- #
# Generates a list of 20 dice rolls with the helper function, and then
# finds the longest run in the list and marks that with brackets.
# If there are multiple of the same length runs, the first run that
# appears will be marked.
def longestSequenceRun():

    rolls = diceRolls()

    longestRun = 0
    longestRunIndexes = [0, 0]
    inRun = False
    startRun = 0
    endRun = 0
    runCount = 1

    for i in range(len(rolls)-1):

        if inRun and rolls[i] == rolls[i+1]:
            runCount += 1
        elif rolls[i] == rolls[i+1]:
            inRun = True
            startRun = i
        elif inRun and rolls[i] != rolls[i+1]:
            inRun = False
            endRun = i
            
            if runCount > longestRun:
                longestRun = runCount
                longestRunIndexes[0], longestRunIndexes[1] = startRun, endRun
                runCount = 1

    rolls.insert(longestRunIndexes[0], str('('))
    rolls.insert(longestRunIndexes[1]+2,str(')'))
    del(rolls[-1])
    rolls = "".join(str(e) for e in rolls)

    return rolls

# ------------------------------------------------------------------- #
# Takes a list L with values of either True or False and returns
# the longest run of consecutive False elements
# If length of False run is only 1, then the index of the first 
# instance of 'False' is returned instead
def longestFalse(L):

    L.append('END')

    longestRun = 0
    longestRunIndexes = [0, 0]
    inRun = False
    startRun = 0
    endRun = 0
    runCount = 1

    for i in range(len(L)-1):
  
        if inRun and L[i] == L[i+1] == False:
            runCount += 1
        elif L[i] == L[i+1] == False:
            inRun = True
            startRun = i
        elif inRun and L[i] != L[i+1]:
            inRun = False
            endRun = i
            
            if runCount > longestRun:
                longestRun = runCount
                longestRunIndexes[0], longestRunIndexes[1] = startRun, endRun
                runCount = 1
    del(L[-1])

    if longestRunIndexes[0] == longestRunIndexes[1] == 0:
        return (L.index(False), )
    return tuple(longestRunIndexes)


# ------------------------------------------------------------------- #
# Helper function for printing the current state of 'nests'
# in the following function.
def printCurrentNest(nests):
    
    printOutput = []
    for nest in nests:
        if nest == False:
            printOutput.append("_")
        else:
            printOutput.append("X")
    return ' '.join(printOutput)

# ------------------------------------------------------------------- #
# Takes a list nests which indicates empty nests for birds.
# A bird will occupy the center of the longest run of unoccupied nests. 
# This loop continues until all nests are occupied.
def occupy(n):

    # Unoccupied nests are False, occupied are True
    nests = [False for x in range(n)]

    while False in nests:

        print(printCurrentNest(nests))

        mostEmptyNests = longestFalse(nests)
        if len(mostEmptyNests) == 1:
            newlyOccupiedNestIndex = mostEmptyNests[0]
        else:
            newlyOccupiedNestIndex = int((mostEmptyNests[0] + mostEmptyNests[1] + 1)/2)
        nests[newlyOccupiedNestIndex] = True
        
    return printCurrentNest(nests)

# Takes a list L and returns whether the list is a 
# palindriome (same forwards and backwards)
def isPal(L):

    copy = L.copy()
    copy.reverse()
    return L == copy
   


# testing block
if __name__ == "__main__":

    print(sequenceRun())
    print(longestSequenceRun())
    L = [True, False, False, True, False, True, False]
    print(longestFalse(L))
    print(occupy(10))
    L2 = [5, 2, 9, 9, 2, 5]
    print(isPal(L2))

