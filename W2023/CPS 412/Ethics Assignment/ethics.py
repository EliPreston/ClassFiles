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





        # fig = plt.figure(figsize=(5, 5))
        fig = plt.figure()
        fig.set_figwidth(10)
        fig.set_figheight(7)
        plt.subplots_adjust(bottom=0.25)

        # plt.pie(v, autopct="%.2f")
        # whole = plt.Circle((0,0), 0.65, facecolor='white')
        # plt.gcf().gca().add_artist(whole)



        # plt.legend(k, loc = 'lower left')
        # plt.ylabel("")
        

        plt.bar(k, v, color='maroon', width=0.2)
        plt.xticks(rotation=45, ha='right', wrap=True)

        # plt.xlabel("Answers")
        plt.ylabel("# of people")

        plt.title(column, wrap=True)
        plt.show()
        
    i += 1




