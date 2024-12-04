## 1. 문제 정보
문제: 토마토
링크: https://www.acmicpc.net/problem/7569

### 문제

철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다. 토마토는 아래의 그림과 같이 격자모양 상자의 칸에 하나씩 넣은 다음, 상자들을 수직으로 쌓아 올려서 창고에 보관한다.

창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다. 하나의 토마토에 인접한 곳은 위, 아래, 왼쪽, 오른쪽, 앞, 뒤 여섯 방향에 있는 토마토를 의미한다. 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지 그 최소 일수를 알고 싶어 한다.

토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때, 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.

### 제한사항
첫 줄에는 상자의 크기를 나타내는 두 정수 M,N과 쌓아올려지는 상자의 수를 나타내는 H가 주어진다. M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다. 단, 2 ≤ M ≤ 100, 2 ≤ N ≤ 100, 1 ≤ H ≤ 100 이다. 둘째 줄부터는 가장 밑의 상자부터 가장 위의 상자까지에 저장된 토마토들의 정보가 주어진다. 즉, 둘째 줄부터 N개의 줄에는 하나의 상자에 담긴 토마토의 정보가 주어진다. 각 줄에는 상자 가로줄에 들어있는 토마토들의 상태가 M개의 정수로 주어진다. 정수 1은 익은 토마토, 정수 0 은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다. 이러한 N개의 줄이 H번 반복하여 주어진다.

토마토가 하나 이상 있는 경우만 입력으로 주어진다.

## 2. 접근 방식
1. 상자 리스트 생성, 상자(box)에 1이 존재하는 위치를 큐(q)에 저장
```python
x, y, z = map(int, input().split())

box = []
q = deque()

for height in range(z):
    layer = []
    for row in range(y):
        i = list(map(int, input().split()))
        layer.append(i)
        for index in range(x):
            if i[index] == 1:
                q.append([height, row, index, 0])
    box.append(layer)
```
2. 6방향 조건에 맞춰서 bfs 구현, 상자 업데이트
```python
direction = [(-1, 0, 0), (0, 1, 0), (1, 0, 0), (0, -1, 0), (0, 0, -1), (0, 0, 1)]

level = 0
while q:
    tz, tx, ty, tl = q.popleft()
    
    for dz, dx, dy in direction:
        row = tx + dx
        col = ty + dy
        height = tz + dz
        if 0 <= row < y and 0 <= col < x and 0 <= height < z and box[height][row][col] == 0:
            box[height][row][col] = 1
            q.append([height, row, col, tl+1])
    level = tl
```

3. 상자에 0이 존재하면 -1, 아니면 level 출력
```python
for height in box:
    for row in height:
        if row.count(0):
            level = -1
            break

print(level)
```
## 3. 회고
리스트로 구현할 시 시간초과로 deque 라이브러리를 사용해야지 문제를 풀 수 있다.

### +Solution

### 유용한 라이브러리 or 메서드
