

def bSearch(l, v):

    low, high = 0, len(l) - 1

    while low <= high:
        mid = (high+low) // 2

        if v < l[mid]:
            high = mid - 1
        elif v > l[mid]:
            low = mid + 1
        else:
            return "Item at index:" , mid
    return None


if __name__ == "__main__":

    items = [1, 2, 4, 5, 7, 96, 212, 1234, 5678, 3456765]
    value = 96
    print(bSearch(items, value))
        



