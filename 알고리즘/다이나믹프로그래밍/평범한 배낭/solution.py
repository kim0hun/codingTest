n, k = map(int, input().split()) # n 물건 수, k 최대 무게

product = [[0, 0]]

for _ in range(n):
    w, v = map(int, input().split())
    product.append([w, v])

dp = []

for _ in range(n+1):
    dp.append([0] * (k+1))
    
for p in range(1, n+1):
    w = product[p][0]
    v = product[p][1]
    for maxWeight in range(1, k+1):
        if maxWeight < w: # 최대 담을 수 있는 무게가 물건 무게보다 작을 경우
            dp[p][maxWeight] = dp[p-1][maxWeight]
        else:
            dp[p][maxWeight] = max(dp[p-1][maxWeight-w] + v, dp[p-1][maxWeight])
        
print(dp[n][k])
