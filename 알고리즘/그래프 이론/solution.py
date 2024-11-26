from collections import deque

N, K = map(int, input().split())

arr = [0] * ( 100000 + 1 )
visited = [0] * (100000 + 1)

def bfs(N,K) : 
  queue = deque()
  if N >= K :
    sub = N-K
    arr[K] = sub
    return 
  
  queue.append(N)   
  
  while(queue) : 
    N = queue.popleft()
    if N == K : 
      break 

    if(0 <= N-1 <= 100000 and not visited[N-1]) : 
      arr[N-1] = arr[N] + 1
      visited[N-1] = 1
      
      queue.append(N-1)

    if(0 <= N+1 <= 100000 and not visited[N+1]) : 
      arr[N+1] = arr[N] + 1
      visited[N+1] = 1

      queue.append(N+1)

    if((N*2) < 100000 and not visited[N*2]) : 
      arr[N*2] = arr[N] + 1
      visited[N*2] = 1

      queue.append(N*2)

bfs(N,K)
print(arr[K])