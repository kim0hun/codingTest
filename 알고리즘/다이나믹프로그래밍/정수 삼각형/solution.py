n = int(input())  # 삼각형의 행 개수 입력

result = [0] * n  # 결과를 저장할 배열 초기화

for line in range(n):
    arr = list(map(int, input().split()))  # 각 행의 숫자 배열 입력
    
    for i in reversed(range(len(arr))):  # 역순으로 탐색
        if i == len(arr) - 1:  # 오른쪽 끝 요소
            result[i] = result[i - 1] + arr[i]
        elif i == 0:  # 왼쪽 끝 요소
            result[i] += arr[i]
        else:  # 중간 요소
            result[i] = max(result[i - 1], result[i]) + arr[i]

print(max(result))  # 최종 최대 합 출력
