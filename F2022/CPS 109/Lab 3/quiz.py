

def gaurd(nums):

    lNew = []

    for i in range(len(nums) - 1):

        if abs(nums[i] - nums[i+1]) == 1:
            lNew.append(nums[i])
            lNew.append('GAURD')
        else:
            lNew.append(nums[i])
    lNew.append(nums[-1])

    return lNew


if __name__ == "__main__":

    num_ints = []

    x = int(input("enter number of elements: \n"))
    i = 0
    while i < x:
        newNum = int(input("Enter a non-zero number: "))
        if newNum == 0:
            print("Hey! I said you can't enter 0! >:(")
        else:
            num_ints.append(newNum)
            i += 1



    print(gaurd(num_ints))