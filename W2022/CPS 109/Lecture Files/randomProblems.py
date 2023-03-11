

from pydoc import ispackage


def isPalindrome(s):
    return True if s == s[::-1] else False
   

def anagramsBad(s1, s2):

    for c in s1:
        sn = s2.replace(c, '', 1)
        if sn == s2:
            return False
        s2 = sn
    return s2 == ''

# def anagramsGood(s1, s2):

   
    


def unique_characters1(text):
    result = ''
    seen = set()

    for c in text:
        if c not in seen:
            result += c
            seen.add(c)
    return result


def charOccurences(text):
    charDict = dict()

    for c in text:
        if c in charDict:
            charDict[c] += 1
        else:
            charDict[c] = 1
    # print(charDict.items())
    return list(charDict.items())





if __name__ == "__main__":
    print(isPalindrome("racecar"))
    print(anagramsBad("ate", "eat"))
    print(anagramsGood("beat", "beta"))
    print(unique_characters1("hello world"))
    print(charOccurences("Hello my name is john smith"))