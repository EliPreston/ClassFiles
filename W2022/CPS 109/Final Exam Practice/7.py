import unittest

def marketResearch(carts):
    
    items = {}
    for l in carts:
        for item in l:
            if item in items.keys():
                items[item] += 1
            else:
                items[item] = 1
    s = sorted(items.items(), key = lambda x: x[1], reverse=True)
    mostCommon = s[0][0]

    items2 = {}
    for l in carts:
        if mostCommon in l:
            for item in l:
                if item in items2.keys():
                    items2[item] += 1
                else:
                    items2[item] = 1
        else:
            pass
    s2 = sorted(items2.items(), key = lambda x: x[1], reverse=True)
    mostCommon2 = s2[1][0]
    out = (mostCommon, mostCommon2)

    return out


class marketResearchTests(unittest.TestCase):
    def test1(self):
        self.assertEqual(marketResearch([['peas','potatoes','gravy','chicken'],['potatoes','gravy','beans','steak'],['potatoes','grapes'],['grapes','steak','beans']]), ('potatoes', 'gravy'))
    def test2(self):
        self.assertEqual(marketResearch([['rgb fans','cpu','graphics card'],['graphics card','rgb fans'],['cpu','monitor'],['graphics card']]), ('graphics card', 'rgb fans'))
    def test3(self):
        self.assertEqual(marketResearch([['rice','black beans'],['rice','water','fanta'],['rice','black beans','sprite'],[]]), ('rice','black beans'))
    def test4(self):
        self.assertEqual(marketResearch([['rice','black beans'],['rice','splenda'],['rice'],['splenda']]), ('rice','black beans'))
    def test5(self):
        self.assertEqual(marketResearch([['grapes','squash'],['squash']]), ('squash','grapes'))

if __name__ == '__main__':
    unittest.main(exit=True)