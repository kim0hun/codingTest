def makeOne(N):
    dp = [0] * (N + 1)  # 1부터 N까지 저장할 배열
    
    for i in range(2, N + 1):  # 2부터 N까지
        dp[i] = dp[i - 1] + 1  # 기본적으로 1을 뺀 경우
        
        if i % 2 == 0:  # 2로 나누어떨어질 경우
            dp[i] = min(dp[i], dp[i // 2] + 1)
        if i % 3 == 0:  # 3으로 나누어떨어질 경우
            dp[i] = min(dp[i], dp[i // 3] + 1)
    
    return dp[N]

N = int(input())
print(makeOne(N))