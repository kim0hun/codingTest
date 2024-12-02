from collections import deque

w, h = map(int, input().split())

box = []
q = deque()
for row in range(h):
    i = list(map(int, input().split()))
    box.append(i)
    for index in range(w):
        if i[index] == 1:
            q.append([row, index, 0])

direction = [(-1, 0), (0, 1), (1, 0), (0, -1)]

level = 0
while q:
    tx, ty, tl = q.popleft()
    
    for dx, dy in direction:
        row = tx + dx
        col = ty + dy
        if 0 <= row < h and 0 <= col < w and box[row][col] == 0:
            box[row][col] = 1
            q.append([row, col, tl+1])
    level = tl

for row in box:
    if row.count(0):
        level = -1
        break

print(level)