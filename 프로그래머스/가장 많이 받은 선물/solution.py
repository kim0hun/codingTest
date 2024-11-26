def solution(friends, gifts):
    
    num = len(friends)
    
    giveAndGet = []
    for _ in range(num):
        giveAndGet.append([0] * num)
    
    dic = {}
    
    for index, value in enumerate(friends):
        dic[value] = index

    giveNum = [0] * num
    getNum = [0] * num
    for gift in gifts:
        giver, getter = gift.split()
        
        giverIdx = dic[giver]
        getterIdx = dic[getter]
        
        giveAndGet[giverIdx][getterIdx] += 1
        
        giveNum[giverIdx] += 1
        getNum[getterIdx] += 1
    
    giftValue = {}
    
    for friend in friends:
        giftValue[friend] = giveNum[dic[friend]] - getNum[dic[friend]]
    
    maxGet = [0] * num
    
    for x, rows in enumerate(giveAndGet):
        for y, value in enumerate(rows):
            if x >= y:
                continue
            if value > giveAndGet[y][x]:
                maxGet[x] += 1
            elif value < giveAndGet[y][x]:
                maxGet[y] += 1
            else:
                if giftValue[friends[x]] > giftValue[friends[y]]:
                    maxGet[x] += 1
                elif giftValue[friends[x]] < giftValue[friends[y]]:
                    maxGet[y] += 1
                else:
                    continue
    
    return max(maxGet)
