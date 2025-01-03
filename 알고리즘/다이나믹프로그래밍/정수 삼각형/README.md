## 1. 문제 정보

문제: 정수 삼각형
링크: https://www.acmicpc.net/problem/1932

### 문제

```
        7
      3   8
    8   1   0
  2   7   4   4
4   5   2   6   5
```

위 그림은 크기가 5인 정수 삼각형의 한 모습이다.

맨 위층 7부터 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때, 이제까지 선택된 수의 합이 최대가 되는 경로를 구하는 프로그램을 작성하라. 아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택할 수 있다.

삼각형의 크기는 1 이상 500 이하이다. 삼각형을 이루고 있는 각 수는 모두 정수이며, 범위는 0 이상 9999 이하이다.

### 제한사항

첫째 줄에 삼각형의 크기 n(1 ≤ n ≤ 500)이 주어지고, 둘째 줄부터 n+1번째 줄까지 정수 삼각형이 주어진다.

## 2. 접근 방식

### 구현 단계
1. 입력 처리:
<br>먼저 삼각형의 행 개수 n과 각 행의 숫자 배열을 입력.
2. 결과 배열 초기화:
<br>result 배열을 사용하여 각 행의 최대 합을 저장.
<br>result[i]는 삼각형의 현재 위치에서 가능한 최대 합을 나타냄.
3. 역순으로 최대 합 계산:
<br>아래에서 위로 삼각형의 각 요소를 탐색하며 최대 합을 갱신.
<br>각 요소에서 가능한 경로(왼쪽 대각선 위 또는 바로 위)를 고려하여 최대 합을 업데이트.
4. 최대 합 출력:
<br>마지막에 result 배열에서 가장 큰 값을 출력.

### 세부 로직
- 각 행의 요소를 역순으로 탐색.
<br>이는 동적 계획법을 사용하기 위해, 이전 행의 결과를 새로운 행에서 바로 사용할 수 있도록 하기 위함.
- 경계 조건 처리:
  - 맨 왼쪽 요소는 바로 위의 요소만 고려.
  - 맨 오른쪽 요소는 바로 위 대각선 왼쪽 요소만 고려.
  - 나머지 요소는 두 경로 중 더 큰 값을 선택하여 합산.

## 3. 회고

처음에 bfs로 풀었는데 메모리 초과로 문제 해결이 불가능.

### +Solution

### 유용한 라이브러리 or 메서드
