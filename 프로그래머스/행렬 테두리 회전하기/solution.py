def rotation(arr, query):
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]
    
    startx = query[0]-1
    starty = query[1]-1
    endx = query[2]-1
    endy = query[3]-1
    
    tempNum = arr[startx][starty]
    minNum = tempNum
    
    currentx = startx
    currenty = starty
    
    d = 0
    while d < 4:
        nextx = currentx + dx[d]
        nexty = currenty + dy[d]
        
        if startx <= nextx <= endx and starty <= nexty <= endy:
            arr[currentx][currenty] = arr[nextx][nexty]
            currentx = nextx
            currenty = nexty
            minNum = min(minNum, arr[nextx][nexty])
        else:
            d += 1

    arr[startx][starty+1] = tempNum
    return minNum

def solution(rows, columns, queries):
    result = []
    
    arr = []
    for row in range(rows):
        arr.append([0] * columns)
    
    count = 1
    for row in range(rows):
        for col in range(columns):
            arr[row][col] = count
            count += 1

    for query in queries:
        result.append(rotation(arr, query))

    return result
        