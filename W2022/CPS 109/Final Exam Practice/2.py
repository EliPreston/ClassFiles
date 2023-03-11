import unittest

def anagramTester(string1, string2):

    for i in string1:
        if i in string2:
            pass
        else:
            return False
    return True
   

class anagramTests(unittest.TestCase):
    def test1(self):
        self.assertEqual(anagramTester('listen','silent'), True)
    def test2(self):
        self.assertEqual(anagramTester('listen','silence'), False)
    def test3(self):
        self.assertEqual(anagramTester('evil','vile'), True)
    def test4(self):
        self.assertEqual(anagramTester('a gentleman','elegant man'), True)
    def test5(self):
        self.assertEqual(anagramTester('this really','shouldn\'t work'), False)


if __name__ == '__main__':
 unittest.main(exit=True)


