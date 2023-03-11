

def sum67(nums):

    skip = False
    sum = 0

    for i in nums:

        if i == 6:
            skip = True
       
            

        if skip:
            sum += 0

        else:
            print(i)
            sum += i

        if i == 7:
            skip = False
    return sum



print(sum67([1, 2, 2, 6, 99, 99, 7]))
