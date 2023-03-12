

suits = ['clubs', 'diamonds', 'hearts', 'spades']
ranks = {
    'two' : 2, 
    'three' : 3,
    'four' : 4,
    'five' : 5,
    'six' : 6,
    'seven' : 7,
    'eight' : 8,
    'nine' : 9,
    'ten' : 10,
    'jack' : 11,
    'queen' : 12,
    'king' : 13,
    'ace' : 14
    }

deck = [ (rank, suit) for suit in suits for rank in ranks]

import random

def deal(n, taken = []):
    result = []
    while len(result) < n:
        c = random.choice(deck)
        if c not in result and c not in taken:
            result.append(c)
    return result

print("Your hand consists of the following cards:")
hand = deal(6)
for i in hand:
    # print(type(i))
    # print(i[0], i[1])
    print(f"{i[0]} of {i[1]}")
