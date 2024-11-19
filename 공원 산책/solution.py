def solution(park, routes):
    direction = {'E': [0, 1], 'S': [1, 0], 'W': [0, -1], 'N': [-1, 0]}
    rowL = len(park[0])
    colL = len(park)
    position = []
    
    for row, values in enumerate(park):
        for col, value in enumerate(values):
            if value == 'S':
                position = [row, col]
    
    for x in routes:
        dirArr = x.split()
        direct, distance = dirArr[0], int(dirArr[1])
        canMove = True
        
        for dist in range(1, distance+1):
            newRow = position[0] + direction[direct][0] * dist
            newCol = position[1] + direction[direct][1] * dist
            if not (0 <= newRow < colL and 0 <= newCol < rowL and park[newRow][newCol] != 'X'):
                canMove = False
                break
        
        if canMove:
            position[0] += direction[direct][0] * distance
            position[1] += direction[direct][1] * distance 
    
    return position