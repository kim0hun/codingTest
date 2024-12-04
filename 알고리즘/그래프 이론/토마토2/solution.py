from collections import deque

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

for height in box:
    for row in height:
        if row.count(0):
            level = -1
            break

print(level)