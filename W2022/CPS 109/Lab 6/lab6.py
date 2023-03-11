
def strings():

    l = []
    for i in range(1,6):
        s = input(f"Enter string {i}/5: ")
        l.append(s)
    
    for i in range(4, -1, -1):
        print(f"String {i+1}/5: {l[i]}")
    return 'Q1 return:', None

        
def maxL(L):

    largest = None
    for i in L:
        if type(i) == float:
            largest = i
    return 'Q2 return:', largest


def longest(L):

    largestyet = L[0]
    for i in L:
        if len(i) > len(largestyet):
            largestyet = i

    return 'Q3 return:', largestyet

import random #needed for next two questions
def listsTuples():

    aL = []
    aT = ()
    for i in range(101):
        aL.append(i)
        aT += (i,)
    # print(aL, aT)

    bL = []
    bT = ()
    for i in range(1, 102, 2):
        bL.append(i)
        bT += (i,)
    # print(bL, bT)

    sqL = []
    sqT = ()
    for i in range(0, 50):
        sqL.append(i**2)
        sqT += (i**2,)
    # print(sqL, sqT)

    rL = []
    rT = ()
    for i in range(60):
        randInt = random.randrange(0, 50)
        rL.append(randInt)
        rT += (randInt,)
    # print(rL, rT)

    zL = []
    zT = ()
    for i in range(50):
        zL.append(0)
        zT += (0,)
    # print(zL, zT)

    return 'Q4 return:', None


def listsComp():

    aL = [x for x in range(101)]
    # print(aL)

    bL = [x for x in range(1, 102, 2)]
    # print(bL)

    cL = [x**2 for x in range(50)]
    # print(cL)

    dL = [random.randrange(0, 50) for x in range(60)]
    # print(dL)

    eL = [0 for x in range(50)]
    # print(eL)
    return 'Q5 return:', None

import math
def perimeter(poly):

    p = 0
    for i in range(len(poly)-1):
        # sqrt( (x2 - x1) ** 2 + (y2 - y1) ** 2)
        
        p1 = poly[i]
        p2 = poly[i+1]
        
        p += math.sqrt( (p2[0] - p1[0])**2 + (p2[1] - p1[1])**2)

    p1 = poly[len(poly)-2]
    p2 = poly[len(poly)-1]
    p += math.sqrt( (p2[0] - p1[0])**2 + (p2[1] - p1[1])**2)

    return 'Q6 return:', p


def permutation(L):

    P = []
    C = list(L)

    while len(C) != 0:

        ele = C.pop(random.randrange(0, len(C)))
        P.append(ele)
    return 'Q7 return:', P




if __name__ == "__main__":

    print(strings())
    print(maxL([6, 2, 3.3, 9, 11.0, 1]))
    print(longest(['blue', 'red', 'the white house', 'green']))
    print(listsTuples())
    print(listsComp())
    print(perimeter([(0, 0), (4, 0), (2, 2)]))
    print(permutation([(0, 0), (20, 0), (20, 10), (0, 10)]))
    