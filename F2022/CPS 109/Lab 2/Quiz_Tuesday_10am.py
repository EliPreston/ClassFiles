

def smallestNumber(a, b, c):

    print(min(a, b, c))
    if a == b or a == c or b == c:
        print("There are equal numbers among us")

smallestNumber(2, 3, 3)


# def smallestNumber2():

#     lowest = 10**10
#     for i in range(3):
#         num = int(input("Input number: "))
#         if num < lowest:
#             lowest = num
#     print(lowest)


# smallestNumber2()