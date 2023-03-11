# Lab 9
# Name: Eli Preston
# Student ID: 501152959

#!/usr/bin/python3
import unittest
from matrices import *
# --------------------------------------------------------------q2.py
# Two-dimensional arrays, simple algorithms
# --------------------------------------------------------------

# --------------------------------------------------------------
# Find the number of values in the matrix that ...
# --------------------------------------------------------------
def count23(matrix):

  c = 0

  for i in range(len(matrix)):
    for j in range(len(matrix[0])):

      if (matrix[i][j] % 2 == 0) and (matrix[i][j] % 3 == 0):
        c += 1
  return c
  
# ----------------------------------------------------------
# Show the matrices that we imported 
# matrix1, matrix2 and using printmx()
# --------------------------------------------------------------

printmx(matrix2)
printmx(matrix3)
printmx(matrix4)
printmx(matrix5)
# --------------------------------------------------------------
# The Testing
# --------------------------------------------------------------
class myTests(unittest.TestCase):
 def test1(self):
  self.assertEqual(count23(matrix1), 6)
 def test2(self):
  self.assertEqual(count23(matrix2), 5)
 def test3(self):
  self.assertEqual(count23(matrix3), 20)
 def test4(self):
  self.assertEqual(count23(matrix4), 16)
 def test5(self):
  self.assertEqual(count23(matrix5), 0)


if __name__ == '__main__':
 unittest.main(exit=True)


# --------------------------------------------------------------
# The End
# --------------------------------------------------------------
