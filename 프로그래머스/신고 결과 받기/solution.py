from collections import defaultdict

def solution(id_list, report, k):
    
    dic = defaultdict(list)
    result = [0] * len(id_list)
    
    for x in set(report):
        dic[x.split()[1]].append(x.split()[0])

    for reporter in dic.values():
        if len(reporter) >= k:
            for user in reporter:
                result[id_list.index(user)] += 1
    
    return result