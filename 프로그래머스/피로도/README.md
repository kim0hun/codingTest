## 1. 문제 정보
문제: 피로도
링크: https://school.programmers.co.kr/learn/courses/30/lessons/87946

### 문제
XX게임에는 피로도 시스템(0 이상의 정수로 표현합니다)이 있으며, 일정 피로도를 사용해서 던전을 탐험할 수 있습니다. 이때, 각 던전마다 탐험을 시작하기 위해 필요한 "최소 필요 피로도"와 던전 탐험을 마쳤을 때 소모되는 "소모 피로도"가 있습니다. "최소 필요 피로도"는 해당 던전을 탐험하기 위해 가지고 있어야 하는 최소한의 피로도를 나타내며, "소모 피로도"는 던전을 탐험한 후 소모되는 피로도를 나타냅니다. 예를 들어 "최소 필요 피로도"가 80, "소모 피로도"가 20인 던전을 탐험하기 위해서는 유저의 현재 남은 피로도는 80 이상 이어야 하며, 던전을 탐험한 후에는 피로도 20이 소모됩니다.

이 게임에는 하루에 한 번씩 탐험할 수 있는 던전이 여러개 있는데, 한 유저가 오늘 이 던전들을 최대한 많이 탐험하려 합니다. 유저의 현재 피로도 k와 각 던전별 "최소 필요 피로도", "소모 피로도"가 담긴 2차원 배열 dungeons 가 매개변수로 주어질 때, 유저가 탐험할수 있는 최대 던전 수를 return 하도록 solution 함수를 완성해주세요.

### 제한사항
- k는 1 이상 5,000 이하인 자연수입니다.
- dungeons의 세로(행) 길이(즉, 던전의 개수)는 1 이상 8 이하입니다.
  - dungeons의 가로(열) 길이는 2 입니다.
  - dungeons의 각 행은 각 던전의 ["최소 필요 피로도", "소모 피로도"] 입니다.
  - "최소 필요 피로도"는 항상 "소모 피로도"보다 크거나 같습니다.
  - "최소 필요 피로도"와 "소모 피로도"는 1 이상 1,000 이하인 자연수입니다.
  - 서로 다른 던전의 ["최소 필요 피로도", "소모 피로도"]가 서로 같을 수 있습니다.

## 2. 접근 방식
1. 가능한 던전의 모든 순서들을 반복문을 돌린다.
```python
dLen = len(dungeons)

result = 0
for dCase in permutations(dungeons, dLen):
    # 로직
```

2. 각 경우의 던전에서 갈 수 있는 최대 길이를 구한다.
```python
for dCase in permutations(dungeons, dLen):
    currentHp = k
    count = 0 # 특정 경우에서 갈 수 있는 최대 던전의 수
    for minHp, costHp in dCase:
        if currentHp < minHp: #피로도가 부족할 경우 끝
            break
        currentHp -= costHp
        count += 1
```

3. 갈 수 있는 던전의 최대 길이값 중 최대 값을 구한다.
```python
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
```

## 3. 회고

### +Solution
1. 내가 푼 풀이
```python
from copy import deepcopy

def dfs(currentHp, dungeons, count, maxCount):
    canNext = False
    for idx, dungeon in enumerate(dungeons):
        minHp, costHp = dungeon
        if currentHp >= minHp:
            nextDungeons = deepcopy(dungeons)
            nextDungeons.pop(idx)
            dCount = dfs(currentHp-costHp, nextDungeons, count+1, maxCount)
            canNext = True
            if dCount > maxCount:
                maxCount = dCount
        
    if not canNext:
        return count
    
    return maxCount
    
def solution(k, dungeons):

    result = dfs(k, dungeons, 0, 0)
    return result
```

2. 깔끔한 풀이
```python
answer = 0
N = 0
visited = []

def dfs(k, cnt, dungeons):
    global answer
    if cnt > answer:
        answer = cnt

    for j in range(N):
        if k >= dungeons[j][0] and not visited[j]:
            visited[j] = 1
            dfs(k - dungeons[j][1], cnt + 1, dungeons)
            visited[j] = 0

def solution(k, dungeons):
    global N, visited
    N = len(dungeons)
    visited = [0] * N
    dfs(k, 0, dungeons)
    return answer
```

### 유용한 라이브러리 or 메서드