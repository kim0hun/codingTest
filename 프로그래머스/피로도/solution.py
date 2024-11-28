from itertools import permutations

def solution(k, dungeons):
    dLen = len(dungeons)

    result = 0
    for dCase in permutations(dungeons, dLen):
        currentHp = k
        count = 0
        for minHp, costHp in dCase:
            if currentHp < minHp:
                break
            currentHp -= costHp
            count += 1
        if result < count:
            result = count

    return result