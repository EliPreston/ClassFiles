import pandas as pd
import matplotlib.pyplot as plt


# https://docs.google.com/spreadsheets/d/18cJEQ-BstuqIAf5aOk28FMcwFPJ03Px1eDqYJdeOmyM/edit?resourcekey#gid=1828664483
SHEET_ID = '18cJEQ-BstuqIAf5aOk28FMcwFPJ03Px1eDqYJdeOmyM'
df = pd.read_csv(f'https://docs.google.com/spreadsheets/d/{SHEET_ID}/export?format=csv')
# print(df)

for column in df:
    print(column)
    print((df[column]))
    # print(type(df[column]))

    print("-----")



