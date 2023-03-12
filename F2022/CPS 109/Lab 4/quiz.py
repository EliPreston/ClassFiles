

def getColour():

    validColour = ["yellow", "orange", "red", "purple", "blue", "green"]
    notValidColour = True

    while notValidColour:

        colour = str(input("Enter a colour: "))
        if colour in validColour:
            return colour
        elif colour == "stop":
            return "stop"
        else:
            print("Please enter a valid colour")

def getClothing():

    validClothing = ["shirt", "pants", "dress", "sweater"]
    notValidClothing = True

    while notValidClothing:

        clothing = str(input("Enter an article of clothing: "))
        if clothing in validClothing:    
            return clothing
        elif clothing == "stop":
            return "stop"
        else:
            print("Please enter a valid article of clothing")


def solution():
    
    clothingList = []
    cont = True

    while cont:

        colour = getColour()
        if colour == "stop":
            return clothingList

        clothing = getClothing()
        if clothing == "stop":
            return clothingList

        clothingList.append(colour + " " + clothing)



if __name__ == "__main__":
    
    print(solution())