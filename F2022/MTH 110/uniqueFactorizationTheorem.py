


'''
U.F.T
for a number n
- there are primes (p1, p2, p3,...., pk)
- and there are positive ints (e1, e2, e3,...., ek)
- such that there are k number of prime's and e's
- where p1^e1 * p2^e2 * p3^e3 * ...... * pk^ek
'''


'''
Libraries
'''
from math import sqrt

'''
Functions
'''

def isPrime(n):
    # n is the number to be check whether it is prime or not    
    # this flag maintains status whether the n is prime or not
    prime_flag = True
    
    if(n > 1):
        for i in range(2, int(sqrt(n)) + 1):
            if (n % i == 0):
                prime_flag = False
                break
        if (prime_flag):
            return True
        else:
            return False
    else:
        return False


def nPrimes(n):
    # Sieve of Eratosthenes

    primesList = [True for i in range(n+1)]
    listOfPrimes = []
    p = 2

    while (p * p <= n):
        # If prime[p] is not
        # changed, then it is a prime
        if (primesList[p] == True):
            listOfPrimes.append(p)
            # Update all multiples of p
            for i in range(p * p, n+1, p):
                primesList[i] = False
        p += 1

    return listOfPrimes

# print(nPrimes(9))


def uniqueFactorizationTheorem(n):

    listPrimes = nPrimes(n)
    print(listPrimes)
    # Print all prime numbers
    # for p in range(2, n+1):
    #     if listPrimes[p]:
    #         listPrimes[p] = p
    # print(listPrimes)

    # ncopy = n
    # currentPrimeIndex = 0
    # while ncopy > 1:

    #     while n % 
        
        


uniqueFactorizationTheorem(12)