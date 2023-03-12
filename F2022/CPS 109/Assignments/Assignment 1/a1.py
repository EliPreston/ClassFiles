'''
Student Number: 501152959
Student Name: Theodore (Eli) Preston
'''

# Problem/Solution: In my physics course there are a lot of tedious calculations (momentum, forces, etc.) 
# involved in the homework questions due every week. These calculations aren't necessarily difficult, but
# having so many vector quantities that need to be multiplied, divided, added, and subtracted can result in
# small mistakes that lead to wrong answers. As a result, this program will perform the calculations for the 
# user by asking what the user would like to calculate, and then performing the required calculation(s) before
# writing the result to a file for the user to see.

# Math library/module
import math

# Constants
gravitationalConstant = 6.67e-11
elecConstant = 9000000000

# Open output.txt file to be appended to, this way all past calculations can be seen 
output = open('output.txt', 'a')


''' Functions below '''

# Magnitude of vector function
def vectorMag(x, y, z):
    # using the square root method in the math module that was imported
    return math.sqrt((x**2 + y**2 + z**2))

# Unit vector functions
def unitVector(x, y, z):
    mag = vectorMag(x, y, z)
    unitVX = x/mag
    unitVY = y/mag
    unitVZ = z/mag
    return unitVX, unitVY, unitVZ

def unitVectorAngles(thetax, thetay, thetaz):
    return math.cos(thetax), math.cos(thetay), math.cos(thetaz)

# Add, subtract vectors
def subtractVector(x, y, z, x2, y2, z2):
    # Also could be considered relative vector pointing from vector 1 (x,y,z) to vector 2 (x2,y2,z2)
    return x2-x, y2-y, z2-z

def addVector(x, y, z, x2, y2, z2):
    return x+x2, y+y2, z+z2

# Multiply or divide vectors by scalar
def multiplyVector(x, y, z, scalar):
    return x*scalar, y*scalar, z*scalar

def divideVector(x, y, z, scalar):
    return x/scalar, y/scalar, z/scalar

# Momentum
def momentum(m, xV, yV, zV):
    return m*xV, m*yV, m*zV

# Average Velocity (momentum/mass = final velocity or average velocity)
def avgVelocity(px, py, pz, m):
    return px/m, py/m, pz/m

# Force of Gravity - general equation
def gravitationalForce(m1, m2, rx, ry, rz, rx2, ry2, rz2):
    
    # r2 relative to r1
    relativeVector = subtractVector(rx, ry, rz, rx2, ry2, rz2)
    # Magnitude of distance between masses
    magDistance = vectorMag(relativeVector[0], relativeVector[1], relativeVector[2])
    # Unit vector of relative vector
    unitV = unitVector(-1*relativeVector[0],-1*relativeVector[1], -1*relativeVector[2])
    # Gravitational force
    magForce = (gravitationalConstant*m1*m2)/(magDistance**2)

    # Vector force
    return multiplyVector(unitV[0], unitV[1], unitV[2], magForce)

# Electric Force
def electricForce(q1, q2, q1x, q1y, q1z, q2x, q2y, q2z):

    # r2 relative to r1
    relativeVector = subtractVector(q1x, q1y, q1z, q2x, q2y, q2z)
    # Magnitude of distance between atoms
    magDistance = vectorMag(relativeVector[0], relativeVector[1], relativeVector[2])
    # Unit vector of relative vector
    unitV = unitVector(relativeVector[0], relativeVector[1], relativeVector[2])
    # Electric force
    forceElec = elecConstant*((q1*q2)/(magDistance**2))

    # Vector force
    return multiplyVector(unitV[0], unitV[1], unitV[2], forceElec)


# Matching the user's input to the correct case (similar structure to an if block)
def matchArg(argument):
    match argument:

        # The "case" keyword is the same as saying "if argument == 1"
        case 1:
            # Here we get the two vectors needed using a loop and appending the values to a list
            # The "\n" is a newline character that simply inserts a new line wherever it is 
            print("\nPlease enter the values of the vectors below: ")
            vectorList = []

            # The outside loops twice (2 vectors total) and the inside loops 3 times each time (3 components to each vector)
            for i in range(1, 3):
                print("\nVector: " + str(i))
                for j in range(3):
                    vecInput = float(input())
                    vectorList.append(vecInput)

            # Once all the values have been added to the list, a variable is declared with it's value 
            # set to the result of the function called (subtractVector in this case)
            answer = subtractVector(vectorList[0], vectorList[1], vectorList[2], vectorList[3], vectorList[4], vectorList[5])
            
            # Here we write the answer to the txt document in a format which makes it easier to read
            # This whole process is repeated for a few of the other cases, and the ones that are different 
            # are much simpler but follow the general idea here
            output.write("Most recent relative vector calculated below (x, y, z): \n")
            # This loop just loops through each element in the variable answer because it is a tuple with 3 elements
            # and writing each value to a new line in the output.txt file
            for i in answer:                
                output.write(str(i) + "\n")
            output.write("\n")
        
        case 2:
            print("\nPlease enter vector below:")
            x = float(input())
            y = float(input())
            z = float(input())
            answer = unitVector(x, y, z)

            output.write("Most recent unit vector calculated below (x, y, z): \n")
            for i in answer:
                output.write(str(i) + "\n")
            output.write("\n")
        
        case 3:
            print("\nPlease enter vector angles from the axes below:")
            x = float(input("Angle from x-axis: "))
            y = float(input("Angle from y-axis: "))
            z = float(input("Angle from z-axis: "))
            answer = unitVectorAngles(x, y, z)

            output.write("Most recent unit vector (from angles) calculated below (x, y, z): \n")
            for i in answer:
                output.write(str(i) + "\n")
            output.write("\n")

        case 4:
            print("\nPlease enter vector below (x, y, z):")
            x = float(input())
            y = float(input())
            z = float(input())
            answer = vectorMag(x, y, z)

            output.write("Most recent vector magnitude calculated below (x, y, z): \n")
            output.write(str(answer) + "\n")
            output.write("\n")

        case 5:
            print("\nPlease enter velocity vector in m/s below (x, y, z):")
            x = float(input())
            y = float(input())
            z = float(input())
            print("\nPlease enter the mass of the object in kg below:")
            m = float(input())
            answer = momentum(m, x, y, z)

            output.write("Most recent momentum calculated below (x, y, z): \n")
            for i in answer:
                output.write(str(i) + "\n")
            output.write("\n")

        case 6:
            vectorList = []
            for i in range(1, 3):
                print("\nEnter the position vector of object " + str(i))
                for j in range(3):
                    vecInput = float(input())
                    vectorList.append(vecInput)
            m1 = float(input("\nPlease enter the mass of the first obejct in kg: "))
            m2 = float(input("Please enter the mass of the second obejct in kg: "))
            answer = gravitationalForce(m1, m2, vectorList[0], vectorList[1], vectorList[2], vectorList[3], vectorList[4], vectorList[5])

            output.write("Most recent gravitational force calculated below (x, y, z): \n")
            for i in answer:
                output.write(str(i) + "\n")
            output.write("\n")
        
        case 7:
            vectorList = []
            for i in range(1, 3):
                print("\nEnter the position vector of atom " + str(i))
                for j in range(3):
                    vecInput = float(input())
                    vectorList.append(vecInput)
            q1 = float(input("\nPlease enter the signed magnitude of the first atom: "))
            q2 = float(input("Please enter the signed magnitude of the second atom: "))
            answer = electricForce(q1, q2, vectorList[0], vectorList[1], vectorList[2], vectorList[3], vectorList[4], vectorList[5])

            output.write("Most recent electric force calculated below (x, y, z): \n")
            for i in answer:
                output.write(str(i) + "\n")
            output.write("\n")

# This if statement runs the program only if the file is run as a script.
# Meaning if the file is imported as a module, it won't run, but the functions are still accessible
if __name__ == "__main__":
    print("*--------------------------------------------------------------*")
    print("* Hello and welcome to this simple physics calculator program! *")
    print("*   Please enter only integers when choosing a calculation     *")
    print("* Please enter only integers/decimals when prompted for values *")
    print("*--------------------------------------------------------------*\n")

    # This try-except structure will catch any incorrect/unknown value enterd
    try:
        print("\nPlease type the number from the below list associated with the calculation you would like to perform:")
        print("1: Relative vector (from vector 1 to vector 2)")
        print("2: Unit vector")
        print("3: Unit vector from angles")
        print("4: Magnitude of vector")
        print("5: Momentum")
        print("6: Gravitational force")
        print("7: Electric force")
        print("---------------------------")
        decision = int(input("Calculation: "))
        matchArg(decision)
        print("The chosen calculation has been performed and has been written to the file titled 'output.txt'.")
        output.close()
    except:
        print("You have entered an undefined value for this program, please run the program again.")