def solution(participant, completion):
    participant.sort()
    completion.sort()
    length = len(participant)
    for i, v in enumerate(participant):
        if i == length-1:
            return v
        else:
            if completion[i] != v:
                return v
            
            
# from collections import Counter

# def solution(participant, completion):
#     answer = Counter(participant) - Counter(completion)
#     return list(answer.keys())[0]