

'''
Loop:
    -Calculate Force
    -update momentum (with timestep t)
    -update position (with timestep t)

'''



def calcForce():

    forceVector = 21
    return forceVector

def updateMomentum(pInitial, fInitial, deltaT):

    pNew = pInitial + (fInitial*deltaT)
    return pNew

def updatePosition(rInitial, vAvg, deltaT):

    rNew = rInitial + (vAvg*deltaT)
    return rNew

def iterativePredictionMotion():

    deltaT = float(input("Enter time step between calculations: "))
    posList = []
    vList = []

    for i in range(3):
        posList.append(float(input(f"Enter position value {i}: ")))
        vList.append(float(input(f"Enter velocity value {i}: ")))



    t = 0
    step = 1

    while t < 10:
        try:
            netForce = calcForce()
            updateP = updateMomentum()
            updateR = updatePosition()
            print(f"For step {step}, force = {netForce}, new momentum = {updateP}, new position = {updateR}")
            t += deltaT
            step += 1
        except:
            break

