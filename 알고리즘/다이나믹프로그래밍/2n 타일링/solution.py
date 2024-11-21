# def cal(n, count):
#     total = count
#     if n > 1:
#         total += cal(n-2, count)
#     if n > 0:
#         total += cal(n-1, count)
#     if n == 0:
#         total += 1
#     return total
    
#######################################

# def cal(n):
#     if n == 1:
#         return 1
#     if n == 2:
#         return 2
#     if n > 2:
#         return cal(n-1) + cal(n-2)
    
i = int(input())

arr = [0] * 1001
arr[0] = 1
arr[1] = 2

for idx in range(len(arr)):
    if arr[idx] == 0:
        arr[idx] = arr[idx-1] + arr[idx-2]
    if idx+1 == i:
        print(arr[idx]%10007)
        break

#####################################