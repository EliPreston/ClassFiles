
# def colour_trio(colours):

#     def combineColours(substr):
#         colourList = ['r', 'y', 'b']

#         if substr[0] == substr[1]:
#             return substr[0]
#         else:
#             for colour in colourList:
#                 if not(colour in substr):
#                     return colour
    
#     while len(colours) > 1:

#         intermediateColours = ''
#         for i in range(1, len(colours)):
#             current = colours[i-1:i+1]
#             intermediateColours += combineColours(current)
#         colours = intermediateColours
    
#     return colours

# print(colour_trio('rbyryrrbyrbb'))

# def count_dominators(items):

#     if len(items) == 0:
#         return 0

#     dominators = 0
#     currentMax = items[-1]

#     for i in range(len(items)-1, -1, -1):

#         if items[i] >= currentMax:
#             dominators += 1
#             currentMax = items[i]

#     return dominators
    

# x = [99, 100]
# print(count_dominators(range(10**7, 0, -1)))


# def extract_increasing(digits):

#     nums = []
#     currentNum = int(digits[0])
#     synthesizedNum = ''
#     while len(digits) > 0:



def taxi_zum_zum(moves):

    initialPos =[0, 0]
    moveDirectionIndex = 1

    for i in moves:
        if i == 'R':
            moveDirectionIndex += 1
            if moveDirectionIndex == 4:
                moveDirectionIndex = 0
        elif i == 'L':
            moveDirectionIndex -= 1
            if moveDirectionIndex == -1:
                moveDirectionIndex = 3

        elif i == 'F':
            if moveDirectionIndex == 1:
                initialPos[1] += 1
            elif moveDirectionIndex == 2:
                initialPos[0] += 1
            elif moveDirectionIndex == 0:
                initialPos[0] -= 1
            elif moveDirectionIndex == 3:
                initialPos[1] -= 1

    return (initialPos[0], initialPos[1])

print(taxi_zum_zum('FFLLLFRLFLRFRLRRL'))