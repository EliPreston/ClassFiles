import unittest
# Note that today's Quiz will be a bit different than usual
# Firstly, you will be completing this individually (no communication)
# Secondly, this will be closed-book (other than the official Python documentation)
# Thirdly, please only make changes where the comments indicate, on this file itself
# Finally, to get full marks, you must complete all 7/7 tasks


# Your first task is to create a function called find_lowest_value that finds the lowest value of some input list of floats L and returns its index
# TODO: Complete find_lowest_value

def find_lowest_value(l):
    return l.index(min(l))

# Your second task will be to create a function called remove_all_qs that takes in a string s and returns the string with all instances of the letter q removed
# TODO: complete remove_all_qs

def remove_all_qs(s):
    elements = list(s)
    while 'q' in elements:
        elements.remove('q')
    return ''.join(elements)

# Your third task will be to create a function called find_biggest_mult that takes in two nonempty lists of integers and returns the indices of the two numbers that result in the largest product (one from each list) that, when multiplied, give the biggest product. Return as a tuple.
# TODO: complete find_biggest_mult

def find_biggest_mult(l1, l2):
    max1 = l1.index(max(l1))
    max2 = l2.index(max(l2))

    min1 = l1.index(min(l1))
    min2 = l2.index(min(l2))

    if min(l1)*min(l2) > max(l1)*max(l2):
        return (min1, min2)
    return (max1, max2)

# Find biggest mult_negative, 

# def find_biggest_mult_negative(l1, l2):
    
    


# Your fourth task will be to create a recursive function rec_mul that takes in a list of integers L and if there is one element returns it, else it returns the value of the first integer in the list times rec_mul of the list minus that element
# TODO: complete rec_mul

def rec_mul(l):

    if len(l) == 1:
        return l[0]
    else:
        ele = l[0]
        l.remove(l[0])
        return ele * rec_mul(l)



class QuizTestCases(unittest.TestCase): # Your fifth task will be to complete all unittests here.
    def test_1_find_lowest_value_normal(self): # An example for you...
        self.assertEqual(find_lowest_value([4, 5, 3, 3, 0, -3]), 5)

    def test_2_remove_all_qs(self): # Create a test case for the remove_all_qs function
        self.assertEqual(remove_all_qs('qq112233qq'), '112233')

    def test_3_find_biggest_mult(self): # Create TWO test cases for the find_biggest_mult function
        self.assertEqual(find_biggest_mult([1, 2, 3, 5, 6, 7], [10, 9, 8, 7, 100, 20, 11]), (5, 4))
        self.assertEqual(find_biggest_mult([8, 6, 33, 22, 1, -1], [110, -9, 30, 105, 345, 2, 11]), (2, 4))

    def test_4_find_biggest_mult_negative(self): # ... hint: consider two lists with negative values
        self.assertEqual(find_biggest_mult([-2, -10, 4, -5, 8, -1], [0, 2, 4, -8, 9]), (1, 3))

    def test_5_rec_mul(self): # Create a test case for the rec_mul function
        self.assertEqual(rec_mul([1, 2, 3, 4, 5]), 120)
        self.assertEqual(rec_mul([2]), 2)


    
if __name__ == "__main__":
    print("Running quiz")
    

    # Your sixth last task is to create some string, call the remove_all_qs function on that string such that it permanently changes the string, then print that edited string
    # TODO: do the above
    exampleS = 'hello q worqldq!'
    print(f"String before being changed: {exampleS}")

    exampleS = remove_all_qs(exampleS)
    print(f"String after being changed: {exampleS}")


    # Your final task will be to call the find_lowest_value function on a list, such that it returns the value 3. You pick the list so that this is the case.
    # TODO: do the above
    exampleL = [0, 1, 3, -100000, 39, -10, 400, 10]
    print(find_lowest_value(exampleL))

    unittest.main(exit=True)