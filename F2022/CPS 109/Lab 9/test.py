


# matrix = [
#     [1, 2, 3, 4, 5],
#     [5, 6, 7, 8, 7],
#     [9, 10, 11, 12, 11],
#     [1, 2, 3, 4, 5],
#     [13, 14, 15, 16, 15]
# ]

matrix = [[7, 24, 12], [99, 16, 42], [42, 48, 40], [32, 16, 5], [99, 16, 42]]

# row = len(matrix)
# print(row)
# col = len(matrix[0])
# print(col)
# print("------")

transposed = []

for c in range(len(matrix[0])):
    # print("------")
    transposedColumn = []
    for r in range(len(matrix)):
        # print(matrix[r][c])
        transposedColumn.append(matrix[r][c])

    transposed.append(transposedColumn)
print(transposed)



# for row in range(len(matrix)):

#     current = matrix[row]
#     print("--------")
#     print(f"current: {current}")
#     for checkRow in range(row+1, len(matrix)):
#         print(matrix[checkRow])
#         if current == matrix[checkRow]:
#             print("TRUE")

    

# for i in range(len(matrix)):
#     for j in range(len(matrix[0])):
#         print(matrix[i][j])


# ages = {
#     'Matt': 30,
#     'Katie': 29,
#     'Nik': 31,
#     'Jack': 43,
#     'Jill': 43,
#     'Alison': 32,
#     'Kevin': 38
# }

# max_keys = [key for key, value in ages.items() if value == max(ages.values())]

# print(max_keys)

# Returns: ['Jack', 'Jill']


# frequencyDict = {}

# for i in range(len(matrix)):
#     for j in range(len(matrix[0])):

#         num = matrix[i][j]
#         print(num)
#         if num in frequencyDict:
#             frequencyDict[num] += 1
#         else:
#             frequencyDict[num] = 1


# maxFrequency = [key for key, value in frequencyDict.items() if value == max(frequencyDict.values())]
# print(maxFrequency)