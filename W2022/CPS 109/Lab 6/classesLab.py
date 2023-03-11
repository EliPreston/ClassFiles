class car:

    def __init__(self, make, colour, price):
        self.make = make
        self.colout = colour
        self.price = price


# In class example
class person:

    def __init__(self, name, height, age): # init initializes an object with some values at first, self

        # the self.xxxxx doesn't have to be the same as the varibales named in the function, but you want to make it easier for yourself
        self.name = name
        self.height = height
        self.age = age
        self.friends = ['mom']
    
    # methods for what the object/instance can do
    def look(self, angle, direction):
        print(angle, direction)

    def talk(self, say):
        print("My name is ", self.name)

    def run(self, distance):
        print(distance)



if __name__ == "__main__":

    f = open('CPS 109/Lab 6/classesExample.txt', 'a')
    # Self is implicit in the call
    # Don't need to pass in an argument to initialize an object
    # The base initialization would be what is in the original init function
    exampleVariable = person('john', 180, 25)

    attributeList = exampleVariable.__dict__
    # attributeList = dir(exampleVariable)
    print(attributeList)
   
    for key in attributeList:
        print(key)

    # for i in attributeList:
    #     attribute = attributeList[i]
    #     print(attribute)
        # f.write(str(exampleVariable.) + "\n")

    # Accessing objects - instanceOfObject.attribute
    print(exampleVariable.name)
    print(exampleVariable.height, "cm")
    print(exampleVariable.age)
