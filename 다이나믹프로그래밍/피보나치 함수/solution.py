caseN = int(input())

arr = []

for _ in range(caseN):
    arr.append(int(input()))
    
for x in arr:
    count0 = 1
    count1 = 0
    for y in range(0, x):
        temp = count0
        count0 = count1
        count1 = temp + count1
    print(count0, count1)