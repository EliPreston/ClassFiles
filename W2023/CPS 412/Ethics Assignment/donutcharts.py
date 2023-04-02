# Eli Preston (501152959)
# Wejd Jabour(501162622)
# Beamlak Tareke (501203039)

# The following imports pandas to read the data, matplotlib to graph the data and dictionaries which is a class that
# holds dictionaries for all the questions that were asked in the survey
import pandas as pd
import matplotlib.pyplot as plt
import dictionaries

# Calls function dictionariesAdd() from dictionaries file
dictionaries.dictionariesAdd()
# Set variable d equal to dictionaries list from dicitonaries file
d = dictionaries.dicts


# Accessing google sheet using pandas
SHEET_ID = '18cJEQ-BstuqIAf5aOk28FMcwFPJ03Px1eDqYJdeOmyM'
df = pd.read_csv(f'https://docs.google.com/spreadsheets/d/{SHEET_ID}/export?format=csv')


# Set counter so we can access each dictionary which corresponds to each survey question sequentially
i = 0
# For loop which accesses the pandas data structure holding all the google sheets info
# Column is the question from the survey
for column in df:

    # Set curr variable to the dictionary at counter i
    curr = d[i]

    # Because the timestamp is irrelevant to the graphed data, check if the current column is the timstamp 
    # header (it is automatically added into the google sheets) and ignore that column
    if column == "Timestamp":
        continue

    # If not the timestamp header, run main code
    else:

        # Loop through each answer from the data set at the specific column/question
        for ans in df[column]:

            # If the answer is one of the keys in the dictionary stored in curr,
            # add +1 to the dictionary at that key/answer
            if ans in curr.keys():
                curr[ans] += 1

            # If the answer does not exist in the dictionary, check if counter i is 7 or 10
            # This check is for the multiple select questions where the answer can contain 
            # more than one of the possible selected answers
            else:    
                if (i == 7) or (i == 10):

                    # If the counter is 7 or 10 (question 7 or 10), loop through the keys in the
                    # current dictionary (dictionary for question 7 or 10) and 
                    for key in list(curr.keys()):

                        # if any of the keys are contained in the answer, which is stored as a long string, 
                        # then increment the counter at that specifc (singular) key
                        if key in ans:
                            curr[key] += 1
                        
                        # else continue
                        else:
                            continue
                
                # If the current question is not 7 or 10 (and it isn't in the current dictionary keys)
                # create a key called "Other" and increment it by 1 as an initialization
                # This catches any fill in answers from people
                else:
                    otherKey = "Other"
                    curr["Other"] += 1
     
       
        # This next piece removes any empty answers so they don't show up in the graphs
        # Creates a list that holds the keys of the empty questions, checks the current dictionary
        # for empty answers and appends the key to the list if it is empty (or equal to 0)
        itemstodelete = []
        for keyDEL in curr:
            if curr[keyDEL] == 0:
                itemstodelete.append(keyDEL)

        # Loop through list of keys to delete and deletes the key:value from the current dictionary
        for j in itemstodelete:
            del(curr[j])
        
        # Convert keys and values of current dictionary to a list in order to plot on a graph
        k = list(curr.keys())
        v = list(curr.values())

        # Create a matplotlib figure and set dimensions and padding
        fig = plt.figure()
        fig.set_figwidth(10)
        fig.set_figheight(7)
        plt.subplots_adjust(bottom=0.25)


        # Donut chart code
        # Creates a pie chart using the data from lists v and k
        plt.pie(v, labels=k, autopct="%.2f", pctdistance=0.75)

        # Creates a circle and places it inside the piechart to give the appearance of a hole in the middle
        whole = plt.Circle((0,0), 0.4, facecolor='white')
        plt.gcf().gca().add_artist(whole)

        # Set chart title and then show the chart
        plt.title(column, wrap=True, fontweight='bold')
        plt.show()

        # Save the chart as a png file
        filename = 'pie' + str(i) + 'chart.png'
        fig.savefig(filename)
        
    # Increment counter to move to the next dictionary corresponding to the next question
    i += 1




