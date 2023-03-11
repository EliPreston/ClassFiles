import random

def quizSolution():

    initialLoop = True
    secondLoop = False

    matrixOfLists = []
    currentList = []
    
    while initialLoop:
        uInput = input("Enter an integer: ")
        try:
            if uInput == '':
                matrixOfLists.append(currentList)
                currentList = []
                secondLoop = True
                # print("going to second loop")
            else:
                uInput = int(uInput)
                currentList.append(uInput)
        except:
            print("Please enter a valid integer.")
        
        while secondLoop:

            uInput = input("Enter an integer: ")
            try:
                if uInput == '':
                    secondLoop = False
                    initialLoop = False
                    matrixOfLists.append(currentList)
                    # print("breaking out of all loops")
                    break
                else:
                    uInput = int(uInput)
                    currentList.append(uInput)
                    secondLoop = False
                    # print("breaking out of second loop, returning to first loop")
                    break
            except:
                print("Please enter a valid integer.")
                break

    del(matrixOfLists[-1])
    # print(matrixOfLists)
    return matrixOfLists


if __name__ == "__main__":

    m = quizSolution()

    possibleNums = []
    for i in range(0, len(m), 2):
        evenIndexList = m[i]
        for oddIndex in range(1, len(evenIndexList), 2):
            possibleNums.append(evenIndexList[oddIndex])
    randValue = possibleNums[random.randint(0, len(possibleNums)-1)]

    for i in range(1, len(m), 2):
        oddIndexList = m[i]
        for evenIndex in range(0, len(oddIndexList), 2):
            oddIndexList[evenIndex] = oddIndexList[evenIndex]*randValue
        
    print(f"The random number selected was: {randValue}")
    print(m)
        



    