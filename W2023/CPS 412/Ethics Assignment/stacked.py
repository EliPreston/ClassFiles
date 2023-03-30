import pandas as pd
import matplotlib.pyplot as plt
import numpy as np

import dictionaries
dictionaries.dictionariesAdd()
d = dictionaries.dicts


# ''' https://docs.google.com/spreadsheets/d/18cJEQ-BstuqIAf5aOk28FMcwFPJ03Px1eDqYJdeOmyM/edit?resourcekey#gid=1828664483'''
SHEET_ID = '18cJEQ-BstuqIAf5aOk28FMcwFPJ03Px1eDqYJdeOmyM'
df = pd.read_csv(f'https://docs.google.com/spreadsheets/d/{SHEET_ID}/export?format=csv')



# Get indexes of answers of level of education (stored in dict)
stackedLevelDict = {
        "Undergraduate - 1st year": [],
        "Undergraduate - 2nd year": [],
        "Undergraduate - 3rd year": [],
        "Undergraduate - 4th year": [],
        "Diploma": [],
        "Bachelors Degree": [],
        "Masters Degree": [],
        "PhD": []
}
        
count = 0
for ans in df['What is your current or highest level of education achieved?']:
    stackedLevelDict[ans].append(count)
    count += 1


itemstodelete = []
for keyDEL in stackedLevelDict:
    if len(stackedLevelDict[keyDEL]) == 0:
        itemstodelete.append(keyDEL)

for j in itemstodelete:
    del(stackedLevelDict[j])


stackedUsedDict = {
        "Undergraduate - 1st year": [0, 0],
        "Undergraduate - 2nd year": [0, 0],
        "Undergraduate - 3rd year": [0, 0],
        "Undergraduate - 4th year": [0, 0],
        "Diploma": [0, 0],
        "Bachelors Degree": [0, 0],
        "Masters Degree": [0, 0],
        "PhD": [0, 0]
}

count2 = 0
for ans in df['Have you used ChatGPT?']:
    # print(ans)
    for key in stackedLevelDict:

        if (count2 in stackedLevelDict[key]):
            if ans == 'Yes':
                stackedUsedDict[key][0] += 1
            elif ans == 'No':
                stackedUsedDict[key][1] += 1
    count2 += 1



itemstodelete2 = []
for keyDEL in stackedUsedDict:
    if (stackedUsedDict[keyDEL][0] == 0) and (stackedUsedDict[keyDEL][1] == 0):
        itemstodelete2.append(keyDEL)

for j in itemstodelete2:
    del(stackedUsedDict[j])

k = list(stackedUsedDict.keys())
v = list(stackedUsedDict.values())

ugrd1 = v[0]
ugrd2 = v[1]
ugrd3 = v[2]
ugrd4 = v[3]
diplo = v[4]
bachdeg = v[5]

yestotal = 0
nottotal = 0
for i in v:
    yestotal += i[0]
    nottotal += i[1]


legendLabels = [
    (k[0] +  '  | Yes - ' + str( round((ugrd1[0] / yestotal * 100), 2))  + '%  | No - ' + str( round((ugrd1[1] / nottotal * 100), 2)) + "%"),
    (k[1] +  ' | Yes - ' + str( round((ugrd2[0] / yestotal * 100), 2))  + '%    | No - ' + str( round((ugrd2[1] / nottotal * 100), 2)) + "%"),
    (k[2] +  '  | Yes - ' + str( round((ugrd3[0] / yestotal * 100), 2))  + '%  | No - ' + str( round((ugrd3[1] / nottotal * 100), 2)) + "%"),
    (k[3] +  '  | Yes - ' + str( round((ugrd4[0] / yestotal * 100), 2))  + '%    | No - ' + str( round((ugrd4[1] / nottotal * 100), 2)) + "%"),
    (k[4] +  '                             | Yes - ' + str( round((diplo[0] / yestotal * 100), 2))  + '%    | No - ' + str( round((diplo[1] / nottotal * 100), 2)) + "%"),
    (k[5] +  '              | Yes - ' + str( round((bachdeg[0] / yestotal * 100), 2))  + '%    | No - ' + str( round((bachdeg[1] / nottotal * 100), 2)) + "%")
]
xLabels = ['Yes\n('+str(yestotal)+')', 'No\n('+str(nottotal)+')']

# Create stacked bar chart
fig = plt.figure()
fig.set_figwidth(10)
fig.set_figheight(7)

plt.bar(xLabels, ugrd1, color='red', width=0.7)
plt.bar(xLabels, ugrd2, bottom=ugrd1, color='blue', width=0.7)
plt.bar(xLabels, ugrd3, bottom=np.array(ugrd1)+np.array(ugrd2), color='green', width=0.7)
plt.bar(xLabels, ugrd4, bottom=np.array(ugrd1)+np.array(ugrd2)+np.array(ugrd3), color='yellow', width=0.7)
plt.bar(xLabels, diplo, bottom=np.array(ugrd1)+np.array(ugrd2)+np.array(ugrd3)+np.array(ugrd4), color='pink', width=0.7)
plt.bar(xLabels, bachdeg, bottom=np.array(ugrd1)+np.array(ugrd2)+np.array(ugrd3)+np.array(ugrd4)+np.array(diplo), color='maroon', width=0.7)


plt.ylabel("Total number of People Per Answer", fontweight='bold')
# plt.xlabel(, fontweight='bold')
plt.xticks(fontweight='bold')
plt.legend(legendLabels, loc='upper right')
plt.title("Have you used ChatGPT?", fontweight='bold')
plt.show()
