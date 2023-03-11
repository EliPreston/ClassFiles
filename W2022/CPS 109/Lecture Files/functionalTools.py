

# LAMBDA functions only do one thing and one thing only
# f = lambda n: n > 0
# f is name of lambda
# Lambda is the keyword
# n is paramter list, can have more than one parameter
# body of lambda 

# sum_3 = lambda a, b, c: a + b + c
# print(sum_3(1, 2, 3))

# def doToList(nums, func):

#     for i in range(len(nums)):
#         nums[i] = func(nums[i])


# nums = [1, 2, 3, 4, 5]
# print(nums)

# doToList(nums, lambda n: n+5)
# print(nums)


def is_even(n):
    return not n % 2

nums = [1, 2, 3, 4, 5]

it = filter(is_even, nums)
print(it)
for n in it:
    print(n)