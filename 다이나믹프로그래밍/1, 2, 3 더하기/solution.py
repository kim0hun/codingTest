def cal(n):
    if n == 0:
        return 1
    elif n == 1:
        return cal(n-1)
    elif n == 2:
        return cal(n-1) + cal(n-2)
    elif n > 2:
        return cal(n-1) + cal(n-2) + cal(n-3)
        
caseN = int(input())

arr = []

for _ in range(caseN):
    arr.append(int(input()))

for x in arr:
    print(cal(x))
    