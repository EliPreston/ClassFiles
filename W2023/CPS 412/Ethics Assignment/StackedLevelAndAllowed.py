# The following imports pandas to read the data, matplotlib to graph the data and numpy which is used for the
# graphing of data correctly
import pandas as pd
import matplotlib.pyplot as plt
import numpy as np

# This uses pandas to extract the information from the sheets file that contains the answers of the survey
SHEET_ID = '18cJEQ-BstuqIAf5aOk28FMcwFPJ03Px1eDqYJdeOmyM'
df = pd.read_csv(f'https://docs.google.com/spreadsheets/d/{SHEET_ID}/export?format=csv')

# This is used to separate and hold the indexes of the level of eduction of the people who have answered the survey
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

# This for loop runs through the level of education people have achieved or are currently in and stores the index of
# their response/level in its respective dictionary key value
count = 0
for ans in df['What is your current or highest level of education achieved?']:
    stackedLevelDict[ans].append(count)
    count += 1

# This loop runs through the dictionary of indexes and deletes any answers that got no responses
itemstodelete = []
for keyDEL in stackedLevelDict:
    if len(stackedLevelDict[keyDEL]) == 0:
        itemstodelete.append(keyDEL)

for j in itemstodelete:
    del (stackedLevelDict[j])

# This is used to set how many times an answer was selected from a certain question and relates it to their level of
# education. Within this dictionary, the key corresponds to the level of education the student who answered,
# and the corresponding value is a list related to which answer was provided depending on the index of the list.
# Since this querstion has 5 possible answers, each list has 5 values which relates to what answer each student put
# in their respective level of education

# This specific question is, "Do you think students should be allowed to use ChatGPT for school?"
stackedAllowDict = {
    "Undergraduate - 1st year": [0, 0, 0, 0, 0],
    "Undergraduate - 2nd year": [0, 0, 0, 0, 0],
    "Undergraduate - 3rd year": [0, 0, 0, 0, 0],
    "Undergraduate - 4th year": [0, 0, 0, 0, 0],
    "Diploma": [0, 0, 0, 0, 0],
    "Bachelors Degree": [0, 0, 0, 0, 0],
    "Masters Degree": [0, 0, 0, 0, 0],
    "PhD": [0, 0, 0, 0, 0]
}

# This for loop runs through the question "Do you think students should be allowed to use ChatGPT for school?" and
# increments the answer to the specific index of the list in the dictionary which relates to the answer the specific
# student has answered

# To check what level of education this answer corresponds to we created a counter. This counter refers to the index
# of the data and figures out the level of education from the dictionary of indexes above.
count2 = 0
for ans in df['Do you think students should be allowed to use ChatGPT for school?']:
    for key in stackedLevelDict:
        if count2 in stackedLevelDict[key]:
            if ans == 'Strongly agree':
                stackedAllowDict[key][0] += 1
            elif ans == 'Agree':
                stackedAllowDict[key][1] += 1
            elif ans == 'Neutral':
                stackedAllowDict[key][2] += 1
            elif ans == 'Disagree':
                stackedAllowDict[key][3] += 1
            elif ans == 'Strongly disagree':
                stackedAllowDict[key][4] += 1
    count2 += 1

# This loop runs through the dictionary of answers in relation to the dictionary of indexes and deletes any key values
# that got no responses
itemstodelete2 = []
for keyDEL in stackedAllowDict:
    if (stackedAllowDict[keyDEL][0] == 0) and (stackedAllowDict[keyDEL][1] == 0 and stackedAllowDict[keyDEL][2] == 0) \
            and (stackedAllowDict[keyDEL][3] == 0) and (stackedAllowDict[keyDEL][4] == 0):
        itemstodelete2.append(keyDEL)

for j in itemstodelete2:
    del (stackedAllowDict[j])

# This separates the key and value parts into their respective lists to be used for graphing
k = list(stackedAllowDict.keys())
v = list(stackedAllowDict.values())

# The following separate the lists in relation to the data used for the graphs into their own lists to be used for
# the legend and the graphs
ugrd1 = v[0]
ugrd2 = v[1]
ugrd3 = v[2]
ugrd4 = v[3]
diplo = v[4]
bachdeg = v[5]

# The following initializes variables and stores the total number of replies for each answer in the specific question
# to be graphed, which is used to find specific percentages in relation to the level of education
SAtotal = 0
Atotal = 0
Ntotal = 0
DAtotal = 0
SDAtotal = 0
for i in v:
    SAtotal += i[0]
    Atotal += i[1]
    Ntotal += i[2]
    DAtotal += i[3]
    SDAtotal += i[4]

# This creates the legend which displays what level each color corresponds to and the percent for each bar in the
# bar graph
legendLabels = [
    (k[0] + '   | SA - ' + str(round((ugrd1[0] / SAtotal * 100), 2)) + '%  | A - ' +
     str(round((ugrd1[1] / Atotal * 100), 2)) + '%    | N - ' + str(round((ugrd1[2] / Ntotal * 100), 2)) +
     '%    | DA - ' + str(round((ugrd1[3] / DAtotal * 100), 2)) + '%  | SDA - ' +
     str(round((ugrd1[4] / SDAtotal * 100), 2)) + '%'),

    (k[1] + '  | SA - ' + str(round((ugrd2[0] / SAtotal * 100), 2)) + '%  | A - ' +
     str(round((ugrd2[1] / Atotal * 100), 2)) + '%  | N - ' + str(round((ugrd2[2] / Ntotal * 100), 2)) +
     '%    | DA - ' + str(round((ugrd2[3] / DAtotal * 100), 2)) + '%    | SDA - ' +
     str(round((ugrd2[4] / SDAtotal * 100), 2)) + '%'),

    (k[2] + '   | SA - ' + str(round((ugrd3[0] / SAtotal * 100), 2)) + '%    | A - ' +
     str(round((ugrd3[1] / Atotal * 100), 2)) + '%  | N - ' + str(round((ugrd3[2] / Ntotal * 100), 2)) +
     '%  | DA - ' + str(round((ugrd3[3] / DAtotal * 100), 2)) + '%  | SDA - ' +
     str(round((ugrd3[4] / SDAtotal * 100), 2)) + '%'),

    (k[3] + '   | SA - ' + str(round((ugrd4[0] / SAtotal * 100), 2)) + '%      | A - ' +
     str(round((ugrd4[1] / Atotal * 100), 2)) + '%    | N - ' + str(round((ugrd4[2] / Ntotal * 100), 2)) +
     '%    | DA - ' + str(round((ugrd4[3] / DAtotal * 100), 2)) + '%  | SDA - ' +
     str(round((ugrd4[4] / SDAtotal * 100), 2)) + '%'),

    (k[4] + '                              | SA - ' + str(round((diplo[0] / SAtotal * 100), 2)) + '%    | A - ' +
     str(round((diplo[1] / Atotal * 100), 2)) + '%    | N - ' + str(round((diplo[2] / Ntotal * 100), 2)) +
     '%      | DA - ' + str(round((diplo[3] / DAtotal * 100), 2)) + '%    | SDA - ' +
     str(round((diplo[4] / SDAtotal * 100), 2)) + '%'),

    (k[5] + '               | SA - ' + str(round((bachdeg[0] / SAtotal * 100), 2)) + '%      | A - ' +
     str(round((bachdeg[1] / Atotal * 100), 2)) + '%    | N - ' + str(round((bachdeg[2] / Ntotal * 100), 2)) +
     '%    | DA - ' + str(round((bachdeg[3] / DAtotal * 100), 2)) + '%      | SDA - ' +
     str(round((bachdeg[4] / SDAtotal * 100), 2)) + '%')
]

# This sets the x labels for each bar and the number of responses for each answer below it
xLabels = ['Strongly Agree\n(' + str(SAtotal) + ')', 'Agree\n(' + str(Atotal) + ')', 'Neutral\n(' + str(Ntotal) + ')',
           'Disagree\n(' + str(DAtotal) + ')', 'Strongly Disgree\n(' + str(SDAtotal) + ')']

# Create stacked bar chart and set the wigth and height of the window
fig = plt.figure()
fig.set_figwidth(10)
fig.set_figheight(7)

# Adds the value to its respective bar in the graph and sets a unique color for each of the levels
plt.bar(xLabels, ugrd1, color='red', width=0.7)
plt.bar(xLabels, ugrd2, bottom=ugrd1, color='blue', width=0.7)
plt.bar(xLabels, ugrd3, bottom=np.array(ugrd1) + np.array(ugrd2), color='green', width=0.7)
plt.bar(xLabels, ugrd4, bottom=np.array(ugrd1) + np.array(ugrd2) + np.array(ugrd3), color='yellow', width=0.7)
plt.bar(xLabels, diplo, bottom=np.array(ugrd1) + np.array(ugrd2) + np.array(ugrd3) + np.array(ugrd4), color='pink',
        width=0.7)
plt.bar(xLabels, bachdeg, bottom=np.array(ugrd1) + np.array(ugrd2) + np.array(ugrd3) + np.array(ugrd4) +
                                 np.array(diplo), color='maroon', width=0.7)

# The remaining code adds the y labels, the title and the legend to the graph
plt.xticks(fontweight='bold')
plt.ylabel("Total number of People Per Answer", fontweight='bold')
plt.legend(legendLabels, loc='upper right')
plt.title("Do you think students should be allowed to use ChatGPT for school?", fontweight='bold')

# This prints the graph
plt.show()
