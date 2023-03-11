

class Card:

    # Two underscores means hide this variable from the outside world
    # Essentially, cannot say c.__vals
    # Can still access it, just makes it slightly more complicate
    # Python just renames it instead of actually hiding it
    __vals = {'Ace': 1, 'Two': 2, 'Three': 3, 'Four': 4, 'Five': 5, 'Six': 6, 'Seven': 7}
    
    # Python treats functions with two underscores in fron
    def __init__(self, rank, suit):
        self.suit = suit
        self.rank = rank

    def getLocals(self):
        return locals()
    
    # Print() invokes __str__() behind the scenes
    # So here we are changing the behaviour of print()
    def __str__(self):
        return f"{self.rank} of {self.suit}"
    
    def get_value(self):
        return Card.__vals[self.rank]
    
    def outranks(self, other):
        if other == None:
            return True
        return self.get_value() > other.get_value()



c1 = Card('Two', 'Spades')
c2 = Card('Ace', 'Hearts')

# Print() invokes __str__() behind the scenes
# So calling it here returns what we changed it to
print(c1, c2)
print(c1.get_value())
print(c2.get_value())
print("------")
print(c1.outranks(c2))
print(c2.outranks(c1))