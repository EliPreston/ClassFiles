import unittest

def leastCoins(toonies, loonies, quarters, dimes, nickels):

    total = toonies*200 + loonies*100 + quarters*25 + dimes*10 + nickels*5
    coins = {
        't': 200,
        'l': 100,
        'q': 25,
        'd': 10,
        'n': 5
    } 
    out = []

    for i in coins:
        numOfCoin = total // coins[i]
        out.append(numOfCoin)
        total -= numOfCoin*coins[i]
    return out

        # print(i)
        # print(coins[i])



        


    '''
    Assume that toonies, loonies, quarters, dimes and,
    nickles are all integer values representing the number
    of coins that a user has.

    Given this input, return an array of format
    [toonies, loonies, quarters, dimes, nickels]
    which has the same total value as the original input, but with
    the least amount of coins

    for example leastCoins(2,1,5,0,2) would return
    [3,0,1,1,0]
    As our original input was equal to $6.35, and the way to represent
    that value with the least coins is with 3 toonies, one quarter and 
    one dime.

    Hints: 
    
    1. you may need to use the round(number, numberOfDigits) function
    to deal with floating point precision issues.
    EX: round(10.4999,2) -> 10.50

    2. Remember your modulus (%) and floor division (//) operators
    '''
    pass

class leastCoinsTests(unittest.TestCase):
    def test1(self):
        self.assertEqual(leastCoins(2,1,5,0,2), [3,0,1,1,0])
    def test2(self):
        self.assertEqual(leastCoins(10,0,0,0,10), [10,0,2,0,0])
    def test3(self):
        self.assertEqual(leastCoins(0,0,4,0,0), [0,1,0,0,0])

if __name__ == "__main__":
    unittest.main(exit=True)

