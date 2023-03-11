# Lab 4
# Name: Eli Preston
# Student ID: 501152959


def solution1():
    sum = 0
    for i in range(2, 101, 2): sum += i
    # for i in range(2, 101): 
    #     if i % 2 == 0: sum += i
    return sum

def solution2():
    sum = 0
    for i in range(1, 101): sum += i**2
    return sum 

def solution3():
    for i in range(0, 21):
        print(2**i)

def solution4():
    a = int(input("Enter an integer: "))
    b = int(input("Enter a second integer: "))
    sum = 0
    for i in range(a, b+1):
        if i % 2 == 1:
            sum += i
    return sum

def solution5():
    num = float(input("Input a number: "))
    sum = 0
    for i in str(num):
        if i == ".":
            continue
        if int(i) % 2 == 1:
            sum += int(i)
    return sum

def solution6():

    nums = []
    for i in range(10):
        newNum = int(input("Please enter a number: "))
        if newNum % 2 == 1:
            nums.append(newNum)
    if len(nums) == 0:
        return "Out of the numbers entered, none were odd."
    return max(nums)

def solution7():
    x = str(input("Please enter any characters: "))
    sum = 0
    for i in x:
        if i.isnumeric():
            sum += int(i)
    return sum

def solution8():
    y = str(input("Enter a list of decimal numbers separated by commas (ex - 1.23,2.4,3.123): "))
    nums = y.split(",")
    sum = 0
    for i in nums:
        sum += float(i)
    return sum



if __name__ == "__main__":

    print(solution1())
    print(solution2())
    print(solution3())
    print(solution4())
    print(solution5())
    print(solution6())
    print(solution7())
    print(solution8())