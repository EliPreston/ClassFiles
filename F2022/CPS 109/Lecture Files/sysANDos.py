import sys
import os

# print(sys.version + '\n')
# print(sys.version_info)
# print(type(sys.version_info))
# for i in sys.version_info:
#     print(i)

# print(sys.getrecursionlimit())
# sys.setrecursionlimit(3000)
# print(sys.getrecursionlimit())

print("-----")
a = {'hello': 42, 'world': 99}
b = a

print(sys.getrefcount(a))
print(str(sys.getsizeof(a)) + ' bytes')

a['yeah'] = 55
print(str(sys.getsizeof(a)) + ' bytes')

