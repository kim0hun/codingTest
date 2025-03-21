## 1. 문제 정보
문제: 가장 많이 받은 선물
링크: https://school.programmers.co.kr/learn/courses/30/lessons/258712

### 문제
선물을 직접 전하기 힘들 때 카카오톡 선물하기 기능을 이용해 축하 선물을 보낼 수 있습니다. 당신의 친구들이 이번 달까지 선물을 주고받은 기록을 바탕으로 다음 달에 누가 선물을 많이 받을지 예측하려고 합니다.

- 두 사람이 선물을 주고받은 기록이 있다면, 이번 달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받습니다.
  - 예를 들어 `A`가 `B`에게 선물을 5번 줬고, `B`가 `A`에게 선물을 3번 줬다면 다음 달엔 `A`가 `B`에게 선물을 하나 받습니다.
- 두 사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면,   선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받습니다.
  - 선물 지수는 이번 달까지 자신이 친구들에게 준 선물의 수에서 받은 선물의 수를 뺀 값입니다.
  - 예를 들어 `A`가 친구들에게 준 선물이 3개고 받은 선물이 10개라면 `A`의 선물 지수는 -7입니다. `B`가 친구들에게 준 선물이 3개고 받은 선물이 2개라면 `B`의 선물 지수는 1입니다. 만약 `A`와 `B`가 선물을 주고받은 적이 없거나 정확히 같은 수로 선물을 주고받았다면, 다음 달엔 `B`가 `A`에게 선물을 하나 받습니다.
  - **만약 두 사람의 선물 지수도 같다면 다음 달에 선물을 주고받지 않습니다.**  
  
위에서 설명한 규칙대로 다음 달에 선물을 주고받을 때, 당신은 선물을 가장 많이 받을 친구가 받을 선물의 수를 알고 싶습니다.

친구들의 이름을 담은 1차원 문자열 배열 `friends` 이번 달까지 친구들이 주고받은 선물 기록을 담은 1차원 문자열 배열 `gifts`가 매개변수로 주어집니다. 이때, 다음달에 가장 많은 선물을 받는 친구가 받을 선물의 수를 return 하도록 solution 함수를 완성해 주세요.

### 제한사항
- 2 ≤ `friends`의 길이 = 친구들의 수 ≤ 50
  - `friends`의 원소는 친구의 이름을 의미하는 알파벳 소문자로 이루어진 길이가 10 이하인 문자열입니다.
  - 이름이 같은 친구는 없습니다.
- 1 ≤ `gifts`의 길이 ≤ 10,000
  - `gifts`의 원소는 `"A B"`형태의 문자열입니다. `A`는 선물을 준 친구의 이름을 `B`는 선물을 받은 친구의 이름을 의미하며 공백 하나로 구분됩니다.
  - `A`와 `B`는 `friends`의 원소이며 `A`와 `B`가 같은 이름인 경우는 존재하지 않습니다.

## 2. 접근 방식
1. 주고받은 선물을 이차원 배열로 리스트에 저장
```python
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
```

2. 선물 지수를 딕셔너리에 저장
```python
giftValue = {}

for friend in friends:
    giftValue[friend] = giveNum[dic[friend]] - getNum[dic[friend]]
```

3. 선물 받는 친구가 받을 선물의 수들 계산
```python
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
```

## 3. 회고

### +Solution

### 유용한 라이브러리 or 메서드