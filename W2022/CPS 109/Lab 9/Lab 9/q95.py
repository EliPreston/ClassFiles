# Lab 9
# Name: Eli Preston
# Student ID: 501152959

#!/usr/bin/python3
import unittest
from matrices import *
from q94 import repeatedrow
# --------------------------------------------------------------q4.py
# Two-dimensional arrays, simple algorithms
# --------------------------------------------------------------
def transpose(matrix):

    transposed = []

    for c in range(len(matrix[0])):
        # print("------")
        transposedColumn = []
        for r in range(len(matrix)):
            # print(matrix[r][c])
            transposedColumn.append(matrix[r][c])

        transposed.append(transposedColumn)
    return transposed

# --------------------------------------------------------------
# is there a repeated column?
# --------------------------------------------------------------
def repeatedcolumn(matrix) :

    columnsTransposed = transpose(matrix)
    repeated = repeatedrow(columnsTransposed)
    return repeated

# ----------------------------------------------------------
# Show the matrices that we imported 
# matrix1, matrix2 and using printmx()
# --------------------------------------------------------------
for matrix in [matrix1, matrix2, matrix3, matrix4, matrix5] :
    printmx(matrix)
    print('transpose:')
    printmx(transpose(matrix))

# --------------------------------------------------------------
# The Testing
# --------------------------------------------------------------
class myTests(unittest.TestCase):
 def test1(self):
  self.assertEqual(repeatedcolumn(matrix1), False)
 def test2(self):
  self.assertEqual(repeatedcolumn(matrix2), True)
 def test3(self):
  self.assertEqual(repeatedcolumn(matrix3), False)
 def test4(self):
  self.assertEqual(repeatedcolumn(matrix4), False)
 def test5(self):
  self.assertEqual(repeatedcolumn(matrix5), False)
if __name__ == '__main__':
 unittest.main(exit=True)


# --------------------------------------------------------------
# The End
# --------------------------------------------------------------
