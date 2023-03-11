import unittest

def listMerge(listOfLists):

    output = []
    for l in listOfLists:
        s = sum(l)

        if len(l) == 0:
            pass
        elif s % 2 == 0:
            output.append(s)
        elif s % 2 == 1:
            for i in l:
                output.append(i)
    return output

class listMergeTests(unittest.TestCase):
    def test1(self):
        self.assertEqual(listMerge([[12,22,44],[12,9],[2,4]]),[78,12,9,6])
    def test2(self):
        self.assertEqual(listMerge([[12],[44,11],[4,7,13]]),[12,44,11,24])
    def test3(self):
        self.assertEqual(listMerge([[88,19],[2,4,8,8,12],[8,7,14,12,12],[18,99]]),[88,19,34,8,7,14,12,12,18,99])
    def test4(self):
        self.assertEqual(listMerge([[],[2,4,8,9,12],[18,99]]),[2,4,8,9,12,18,99])
    def test5(self):
        self.assertEqual(listMerge([[],[],[]]),[])

if __name__ == '__main__':
    unittest.main(exit=True)