

# l1 = [1, 2, 3, 4, 5, 6, 7]
# l2 = []
# l3 = [-100]
# l4 = [1, 3, 2, 4, 5, 6, 7, 8]
# l5 = [-1, 0, 2, 4, 5, 6, 7, 9]
# l6 = [1, 1, 1, 1]



# def is_ascending(items):

#     if len(items) < 2:
#         return True
    
#     i = 1
#     while i < len(items):
#         if(items[i] <= items[i - 1]):
#             return False
#         i += 1
#     return True


# for l in [l1, l2, l3, l4, l5, l6]:
#     print(is_ascending(l))

# def riffle(items, out=True):
    
#     riffledList = []
#     if len(items) == 0:
#         return riffledList
    
#     i = 0
#     j = int(len(items)/2)

#     while j < len(items):
#         if out:
#             riffledList.append(items[i])
#             riffledList.append(items[j])
#             i += 1
#             j += 1
#         elif not(out):
#             riffledList.append(items[j])
#             riffledList.append(items[i])
#             i += 1
#             j += 1
    
#     return riffledList


# i = [1, 2, 3, 4, 5, 6, 7, 8]
# print(riffle(i, out=True))
# print(riffle(i, out=False))

# i2 = ['bob', 'jack']
# print(riffle(i2, out=True))
# print(riffle(i2, out=False))



# def is_cyclops(n):
    
#     n = str(n)
#     if n.count('0') > 1:
#         return False
        
#     mid = len(n) // 2
#     if n[mid] == '0':
#         return True
#     return False


# n1, n2, n3, n4, n5, n6 = 0, 101, 98053, 777888999, 1056, 675409820

# for n in [n1, n2, n3, n4, n5, n6]:
#     print(is_cyclops(n))


# def domino_cycle(tiles):

#     if len(tiles) == 0:
#         return True
#     if len(tiles) == 1:
#         if tiles[0][0] == tiles[0][1]:
#             return True
#         return False
    
#     for i in range(1, len(tiles)):
#         y = tiles[i-1]
#         x = tiles[i]
#         # print(y[0], y[1])
#         # print(x[0], x[1])
#         # print("-")

#         if y[1] != x[0]:
#             return False
    
#     if tiles[0][0] == tiles[len(tiles)-1][1]:
#         print(tiles[0][0], tiles[len(tiles)-1][1])
#         return True
#     return False
    
    # print(len(tiles))
    # for i in range(0, len(tiles)):
    #     print(i)
    #     i1 = tiles[i-1]
    #     i2 = tiles[i]

    #     pip1 = i1[1]
    #     pip2 = i2[0]
    #     print(i1, i2)

    #     if pip1 != pip2:
    #         print("-------------")
    #         return False
    #     print("-------------")
    #     return True

# t1 = [(3, 5), (5, 2), (2, 3)]
# # domino_cycle(t1)

# t2 = [(4, 4)]
# # print(domino_cycle(t2))
# t3 = []
# t4 = [(2, 6)]
# t5 = [(5, 2), (2, 3), (4, 5)]
# t6 = [(4, 3), (3, 1)]

# for t in [t1, t2, t3, t4, t5, t6]:
    # print(domino_cycle(t))

# t7 = [(3, 5), (5, 2), (2, 3), (3, 3)]
# domino_cycle(t7)




# def count_dominators(items):

#     for i in items:


# i = [42, 7, 12, 9, 2, 5]
# print(count_dominators(i))



# def winning_card(cards, trump=None):
#     print(cards)

#     ranks = {
#         'two': 2, 'three': 3, 'four': 4, 
#         'five': 5, 'six': 6, 'seven': 7,
#         'eight': 8, 'nine': 9, 'ten': 10, 
#         'jack': 11, 'queen': 12, 'king': 13, 
#         'ace': 14
#         }

#     currentWinner = cards[0]
#     currentWinnerRank = ranks[cards[0][0]]

#     if trump == None:
#         trump = cards[0][1]
#     else:
#         trumpNotFound = True
#         for i in range(len(cards)):
#             if cards[i][1] == trump:
#                 currentWinner = cards[i]
#                 currentWinnerRank = ranks[cards[i][0]]
#                 trumpNotFound = False
#                 break
#         if trumpNotFound:
#             trump = currentWinner[1]
        
    
#     print(currentWinner, currentWinnerRank, trump)
#     print('------')
#     for i in cards:
#         currentRank = ranks[i[0]]
#         currentSuit = i[1]

#         if currentSuit == trump:
#             if currentRank > currentWinnerRank:
#                 currentWinner = i
#                 currentWinnerRank = currentRank
        
#     return currentWinner

# cards = [('five', 'hearts'), ('queen', 'spades'), ('jack', 'hearts'), ('jack', 'clubs')]
# for i in cards:
#     if 'hearts' in i:
#         print('yes')
# print('done')
# print(winning_card(cards, trump='diamonds'))
# cardsTest = [
#     [('ten', 'clubs'), ('jack', 'diamonds'), ('four', 'diamonds'), ('ace', 'diamonds')],
#     [('five', 'clubs'), ('three', 'spades'), ('two', 'spades'), ('two', 'diamonds')],
#     [('five', 'hearts'), ('queen', 'spades'), ('jack', 'hearts'), ('jack', 'clubs')],
#     [('six', 'spades'), ('queen', 'diamonds'), ('three', 'diamonds'), ('seven', 'hearts')]
# ]

# trumpTest = ['clubs', 'diamonds', 'hearts', 'spades', None]

# for i in range(len(cardsTest)):
#     cardL = cardsTest[i]
#     for testTrump in trumpTest:
#         print(winning_card(cardL, testTrump))
#         print('-------')
#     print("******************")




# cards = [('ten', 'clubs'), ('jack', 'diamonds'), ('four', 'diamonds'), ('ace', 'diamonds')]
# cards = [('ace', 'diamonds'), ('ace', 'hearts'), ('ace','spades'), ('two', 'clubs')]
# cards = [('two', 'clubs'), ('ace', 'diamonds'), ('ace','hearts'), ('ace', 'spades')]

# print(winning_card(cards, trump='clubs'))


# def seven_zero(n):

#     num = '7'
#     notFound = True

#     while notFound:
#         result = int(num)%n
#         if result == 0:
#             break
#         else:
#             interimNum1 = num+'0'
#             interimNum2 = num+'7'
            
#             if int(interimNum1) % n == 0:
#                 num = interimNum1
#                 return int(num)
#             elif int(interimNum2) % n == 0:
#                 num = interimNum2
#                 return int(num)
#             else:
#                 num = interimNum2


# x = 77700
# print(seven_zero(x))





def extract_increasing(digits):


    currentLargest = digits[0]
    current = ''
    d = [currentLargest]

    for i in range(1, len(digits)-1):

        current += digits[i]
        if int(current) > int(currentLargest):
            currentLargest = current
            d.append(current)
            current = ''
    return d

        
print(extract_increasing(''))



# def extract_increasing(digits):
#     d = str(digits)
#     l = int(len(d))

#     y = 1
#     out = [int(d[0])]
#     x=0
#     while y <= l-1:
#         if out[len(out)-1] < int(d[x+1:y+1]):
#             out.append(int(d[x+1:y+1]))
#             x += 1
#             y += 1
#             if y-x>1:
#                 x = y-1
#         if y < l:
#             if out[len(out)-1] >= int(d[x+1]):
#                 y += 1
#     return out
