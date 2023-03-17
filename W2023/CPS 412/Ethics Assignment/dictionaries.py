dicts = []

def dictionariesAdd():
    intsitutionType = {
        "University": 0,
        "College": 0,
        "Trade School": 0,
        "Other": 0
    }
    dicts.append(intsitutionType)

    age = {
        "18-20": 0,
        "21-23": 0,
        "24-26": 0,
        "27-29": 0,
        "30+": 0
    }
    dicts.append(age)

    levelofEdu = {
        "Undergraduate - 1st year": 0,
        "Undergraduate - 2nd year": 0,
        "Undergraduate - 3rd year": 0,
        "Undergraduate - 4th year": 0,
        "Diploma": 0,
        "Bachelors Degree": 0,
        "Masters Degree": 0,
        "PhD": 0
    }
    dicts.append(levelofEdu)

    major = {
        "Faculty of Arts": 0,
        "Faculty of Engineering and Architectural Sciences": 0,
        "Faculty of Sciences": 0,
        "Faculty of Law": 0,
        "Faculty of Community Services": 0,
        "Faculty of Business": 0,
        "Other": 0
    }
    dicts.append(major)

    usedChatGPT = {
        "Yes": 0,
        "No": 0
    }
    dicts.append(usedChatGPT)

    avgTimeUsed = {
        "7+ hours": 0,
        "5-6 hours": 0,
        "3-4 hours": 0,
        "1-2 hours": 0,
        "0 hours": 0
    }
    dicts.append(avgTimeUsed)

    usefulness = {
        "Very useful": 0,
        "Useful": 0,
        "Decent/mildly useful": 0,
        "Not very useful": 0,
        "Completely useless": 0,
        "Never used ChatGPT": 0
    }
    dicts.append(usefulness)

    purpose = {
        "Research": 0,
        "Writing help (essays, summarizing passages, etc.)": 0,
        "Math problems": 0,
        "Engineering problems": 0,
        "Programming": 0,
        "Idea generation/brainstorming": 0,
        "Never used it": 0

    }
    dicts.append(purpose)

    retain = {
        "I have retained nearly all the information I have learned/used": 0,
        "I remember some of the information I have learned/used": 0,
        "I find it very difficult to remember the information without going back to ChatGPT or some other source": 0,
        "Never used ChatGPT": 0
    
    }
    dicts.append(retain)

    allowed = {
        "Strongly agree": 0,
        "Agree": 0,
        "Neutral": 0,
        "Disagree": 0,
        "Strongly disagree": 0
    }
    dicts.append(allowed)

    allowedFor = {
        "Assignments": 0,
        "Homework": 0,
        "Quizes": 0,
        "Tests": 0,
        "None of the above": 0
    }
    dicts.append(allowedFor)

    useOfAIToolsSlowsLearning = {
        "Strongly agree": 0,
        "Agree": 0,
        "Neutral": 0,
        "Disagree": 0,
        "Strongly Disagree": 0
    }
    dicts.append(useOfAIToolsSlowsLearning)

    useOfAIToolsDangerNewInfo = {
        "Strongly agree": 0,
        "Agree": 0,
        "Neutral": 0,
        "Disagree": 0,
        "Strongly disagree": 0
    }
    dicts.append(useOfAIToolsDangerNewInfo)

    location = {
        "North America": 0,
        "South America": 0,
        "Europe": 0,
        "Asia": 0,
        "Africa": 0,
        "Australia": 0
    }
    dicts.append(location)


    # for i in dicts:
    #     print(i)

    # print(dicts)