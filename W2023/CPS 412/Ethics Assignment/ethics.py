import pandas as pd
import matplotlib.pyplot as plt

import dictionaries
dictionaries.dictionariesAdd()
d = dictionaries.dicts


''' https://docs.google.com/spreadsheets/d/18cJEQ-BstuqIAf5aOk28FMcwFPJ03Px1eDqYJdeOmyM/edit?resourcekey#gid=1828664483'''
SHEET_ID = '18cJEQ-BstuqIAf5aOk28FMcwFPJ03Px1eDqYJdeOmyM'
df = pd.read_csv(f'https://docs.google.com/spreadsheets/d/{SHEET_ID}/export?format=csv')

f = open("/Users/eli/Desktop/--/ClassFiles/W2023/CPS 412/Ethics Assignment/data.txt", "w")


# for i in range(len(d)):
#     print(i)
#     curr = d[i]
#     print(curr)
#     print(list(curr.keys()))
#     print(list(curr.values()))
#     print("-----")



i = 0
for column in df:
    curr = d[i]

    if column == "Timestamp":
        continue
    else:
        
        for ans in df[column]:

            if ans in curr.keys():
                curr[ans] += 1

            else:    
                if (i == 7) or (i == 10):
                    for key in list(curr.keys()):
                        if key in ans:
                            # print(f"{key} answer is in the given answer")
                            curr[key] += 1
                        else:
                            # print(f"{key} not in ans")
                            continue
                else:
                    otherKey = "Other"
                    curr["Other"] += 1
     
        print(curr)
        print("-----")
        f.write(str(curr) + "\n")        

        k = list(curr.keys())
        v = list(curr.values())

        fig = plt.figure(figsize=(10, 5))
        plt.bar(k, v, color='maroon', width=0.2)
        plt.xlabel("Answers")
        plt.ylabel("# of people")
        plt.title("Question: " + column)
        plt.show()
        
    i += 1


