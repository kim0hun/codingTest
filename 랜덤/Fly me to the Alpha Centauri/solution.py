t = int(input())

for _ in range(t):
    x, y = map(int, input().split())
    distance = y - x
    i = 0
    while (i+1)**2 <= distance:
        i += 1

    result = 0
    if distance != i**2:
        result += ((distance-i**2) // i)
        if distance % i != 0:
            result += 1

    result += i * 2 - 1

    print(result)
