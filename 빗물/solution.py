h, w = map(int, input().split())

arr = list(map(int, input().split()))

block = [''] * h

for x in range(h):
    for y in range(w):
        if arr[y]:
            block[x] += '1'
            arr[y] -= 1
        else:
            block[x] += ' '

result = 0
for v in block:
    result += v.strip().count(' ')
    
print(result)