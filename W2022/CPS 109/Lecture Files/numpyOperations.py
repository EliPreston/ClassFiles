
import numpy as np

# pyList = [1, 2, 3, 4, 5]
# a = np.array(pyList, dtype = 'int32')

# print(f"{a+a}")
# print(f"{a*5}")

# pyList2 = [1e9, 2e9]
# b = np.array(pyList2, dtype = 'int32')
# print(b)

# b = b*2
# print(b)


elems = [1, 2, 3, 4, 5, 6, 7, 8, 9]
a = np.array(elems)
a = a.reshape(3,3)
print(a)
