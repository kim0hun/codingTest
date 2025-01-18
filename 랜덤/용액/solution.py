n = int(input())

arr = list(map(int, input().split()))

start_idx = 0
end_idx = len(arr)-1
temp1 = 0
result = []

while start_idx < end_idx:
    temp1 = arr[start_idx] + arr[end_idx]
    result.append([arr[start_idx], arr[end_idx], abs(temp1)])
    
    if  temp1 > 0:
        end_idx -= 1
    elif temp1 < 0:
        start_idx += 1
    else:
        break

result.sort(key= lambda x: x[2])
print(result[0][0], result[0][1])
