from collections import deque
import sys

def bfs(q, position, building, w, h):
    d = ((-1, 0), (0, 1), (1, 0), (0, -1))
    level = 0
    can_exit = False
    
    while position:
        
        position_x, position_y, level = position.popleft()
        if position_x <= 0 or position_x >= h-1 or position_y <= 0 or position_y >= w-1:
            can_exit = True
            break
        
        while q and q[0][2] == level:
            fire_x, fire_y, fire_level = q.popleft()
            
            for dx, dy in d:
                next_x = fire_x + dx
                next_y = fire_y + dy
                if 0 <= next_x < h and 0 <= next_y < w and building[next_x][next_y] != '#' and building[next_x][next_y] != '*':
                    building[next_x][next_y] = '*'
                    q.append((next_x, next_y, fire_level+1))
        
        for dx, dy in d:
            next_x = position_x + dx
            next_y = position_y + dy
            if 0 <= next_x < h and 0 <= next_y < w and building[next_x][next_y] == '.':
                building[next_x][next_y] = '@'
                position.append((next_x, next_y, level+1))

    if can_exit:
        print(level+1)
    else:
        print('IMPOSSIBLE')

test_case = int(sys.stdin.readline())

for _ in range(test_case):
    w, h = map(int, sys.stdin.readline().split())
    
    q = deque()
    position = deque()
    building = []
    for v in range(h):
        floor = sys.stdin.readline()
        building.append(list(floor[:-1]))
        for i in range(w):
            if floor[i] == '*':
                q.append((v, i, 0))
            if floor[i] == '@':
                position.append((v, i, 0))
 
    bfs(q, position, building, w, h)
    