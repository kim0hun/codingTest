from collections import deque

def bfs(x, y):
    q = deque([(x, y, 0)])
    
    visited = [[0] * w for _ in range(h)]
    visited[x][y] = 1
    
    while q:
        startx, starty, level = q.popleft()
        
        for dx, dy in d:
            nextx = startx+dx
            nexty = starty+dy
            if 0 <= nextx < h and 0 <= nexty < w and island[nextx][nexty] == 'L' and visited[nextx][nexty] == 0:
                q.append((nextx, nexty, level+1))
                visited[nextx][nexty] = 1

    return level

h, w = map(int, input().split())

island = []
for _ in range(h):
    island.append(input())

d = ((-1, 0), (0, 1), (1, 0), (0, -1))
longest = 0

for x in range(h):
    for y in range(w):
        if island[x][y] == 'L':
            longest = max(longest, bfs(x, y))

print(longest)