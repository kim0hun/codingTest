def sol(farm):

    total_visited = []
    direct = [[-1, 0], [0, 1], [1, 0], [0, -1]]

    w = len(farm[0])
    h = len(farm)
    
    cnt = 0
    for x in range(h):
        for y in range(w):
            if farm[x][y] == 1 and [x, y] not in total_visited:
                visited = []
                cnt += 1
                visited.append([x, y])
                total_visited.append([x, y])
                while visited:
                    position = visited.pop(0)
                    for d in direct:
                        next_x = position[0] + d[0]
                        next_y = position[1] + d[1]
                        if 0 <= next_x < h and 0 <= next_y < w and farm[next_x][next_y] == 1 and [next_x, next_y] not in total_visited:
                            visited.append([next_x, next_y])
                            total_visited.append([next_x, next_y])

    return cnt

t = int(input())

result = []

for _ in range(t):
    m, n, k = map(int, input().split())
    farm = []
    for _ in range(n):
        farm.append([0] * m)
    
    for cabbage_position in range(k):
        y, x = map(int, input().split())
        farm[x][y] = 1
    
    result.append(sol(farm))

for x in result:
    print(x)