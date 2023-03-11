# Lab 9
# Name: Eli Preston
# Student ID: 501152959

#!/usr/bin/python3
import unittest
from matrices import *
# --------------------------------------------------------------q3.py
# Two-dimensional arrays, simple algorithms
# --------------------------------------------------------------

# --------------------------------------------------------------
# Find the most frequent value in the matrxi
# --------------------------------------------------------------
def mostfrequent(matrix):

    frequencyDict = {}

    for i in range(len(matrix)):
      for j in range(len(matrix[0])):

        num = matrix[i][j]
        if num in frequencyDict:
          frequencyDict[num] += 1
        else:
          frequencyDict[num] = 1


    maxFrequency = [key for key, value in frequencyDict.items() if value == max(frequencyDict.values())]
    if len(maxFrequency) == 1:
      return maxFrequency[0]
    if len(maxFrequency) > 1:
      return min(maxFrequency)

# ----------------------------------------------------------
# Show the matrices that we imported 
# matrix1, matrix2 and using printmx()
# --------------------------------------------------------------
printmx(matrix1)
printmx(matrix2)
printmx(matrix3)
printmx(matrix4)
printmx(matrix5)
printmx(matrix6)
# --------------------------------------------------------------
# The Testing
# --------------------------------------------------------------
class myTests(unittest.TestCase):
 def test1(self):
  self.assertEqual(mostfrequent(matrix1), 16)
 def test2(self):
  self.assertEqual(mostfrequent(matrix2), 50)
 def test3(self):
  self.assertEqual(mostfrequent(matrix3), 75)
 def test4(self):
  self.assertEqual(mostfrequent(matrix4), -129)
 def test5(self):
  self.assertEqual(mostfrequent(matrix5), 95)
 def test6(self):
  self.assertEqual(mostfrequent(matrix6), 16)

if __name__ == '__main__':
 unittest.main(exit=True)


# --------------------------------------------------------------
# The End
# --------------------------------------------------------------
