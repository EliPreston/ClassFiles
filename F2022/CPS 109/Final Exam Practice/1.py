#!/usr/bin/python3
import unittest
# --------------------------------------------------------------
# Sum = 1/1 + 1/2 + 1/3 + ... + 1/n
# --------------------------------------------------------------
def series0(epsilon) :

    n = 1
    sum = 0

    while True:
        sum += 1/n
        if abs(sum - 4.23) <= epsilon:
            return n
        n += 1



# --------------------------------------------------------------
# The Testing
# --------------------------------------------------------------
class myTests(unittest.TestCase):
 def test1(self):
  self.assertEqual(series0(4), 1)
 def test2(self):
  self.assertEqual(series0(3), 2)
 def test3(self):
  self.assertEqual(series0(1), 14)
 def test4(self):
  self.assertEqual(series0(0.5), 23)
 def test5(self):
  self.assertEqual(series0(0.01), 38)


if __name__ == '__main__':
 unittest.main(exit=True)




# --------------------------------------------------------------
# The End
# --------------------------------------------------------------