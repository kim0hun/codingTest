from itertools import combinations
from copy import deepcopy

def bfs(clab, p2, height, width):
    direction = [[0, 1], [1, 0], [0, -1], [-1, 0]]
    sum = 0
    
    while len(p2):
        position2 = p2.pop(0)
        for idx in range(4):
            x = position2[0] + direction[idx][0]
            y = position2[1] + direction[idx][1]
            if 0 <= x < height and 0 <= y < width and clab[x][y] == 0:
                clab[x][y] = 2
                p2.append([x, y])

    for row in clab:
        sum += row.count(0)

    return sum


height, width = map(int, input().split())

lab = []
p0 = []
p2 = []

for row in range(height):
    a = list(map(int, input().split()))
    for col in range(len(a)):
        if a[col] == 0:
            p0.append([row, col])
        elif a[col] == 2:
            p2.append([row, col])
            
    lab.append(a)

max = 0

for x in combinations(p0, 3):
    clab = deepcopy(lab)
    cp2 = deepcopy(p2)
    for v in x:
        clab[v[0]][v[1]] = 1
    result = bfs(clab, cp2, height, width)
    
    if max < result:
        max = result

print(max)