
def solution(x):
    
    if x <= 0: 
        return 0
    if 0 < x <= 1:
        return x
    else:
        if x <= 0:
            return 1
        else:
            return x * solution(x-1)


if __name__ == "__main__":

    try:
        x = float(input("enter a number you would like the 'snacktorial' of: "))
        print(solution(x))
    except:
        print("invalid input")