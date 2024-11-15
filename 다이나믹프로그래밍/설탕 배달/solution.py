N = int(input())
num5 = N // 5
num3 = -1

while num5 >= 0:
    if (N - num5 * 5) % 3 == 0:
        num3 = (N - num5 * 5) // 3
        break
    else:
        num5 -= 1

if num3 == -1:
    print(-1)
else:
    print(num3 + num5)
