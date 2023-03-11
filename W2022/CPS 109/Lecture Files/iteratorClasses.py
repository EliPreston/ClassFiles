

# Iterator for squares of a number
class Squares:


    def __init__(self, start, end):
        self.start = start
        self.end = end
    
    def __next__(self):
        if self.start > self.end:
            raise StopIteration
        else:
            result = self.start **2
            self.start = self.start + 1
            return result
    
    def __iter__(self):
        return self


s = Squares(1, 10)
print(next(s))
print(next(s))
print(next(s))
print(next(s))
print(next(s))
print(next(s))

