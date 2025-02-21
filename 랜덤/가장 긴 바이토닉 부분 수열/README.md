## 1. 문제 정보

문제: 불

링크: https://www.acmicpc.net/problem/5427

### 문제

2차원 세계에 블록이 쌓여있다. 비가 오면 블록 사이에 빗물이 고인다.

비는 충분히 많이 온다. 고이는 빗물의 총량은 얼마일까?

### 제한사항

첫 번째 줄에는 2차원 세계의 세로 길이 H과 2차원 세계의 가로 길이 W가 주어진다. (1 ≤ H, W ≤ 500)

두 번째 줄에는 블록이 쌓인 높이를 의미하는 0이상 H이하의 정수가 2차원 세계의 맨 왼쪽 위치부터 차례대로 W개 주어진다.

따라서 블록 내부의 빈 공간이 생길 수 없다. 또 2차원 세계의 바닥은 항상 막혀있다고 가정하여도 좋다.

## 2. 접근 방식

1. **입력값 처리**  
   - `h`, `w`는 각각 세로와 가로 크기를 나타낸다.
   - `arr`은 각 열에 쌓인 블록의 높이를 나타내는 배열이다.

2. **블록 상태 표현**  
   - `block` 배열은 각 행마다 블록이 있는 위치를 문자열로 저장한다.  
   - `'1'`은 블록이 있는 위치를, `' '`(공백)은 빈 공간을 나타낸다.
   - 이를 위해 `arr` 배열을 순회하며 블록의 위치를 하나씩 채워나간다.

3. **빈 공간 개수 계산**  
   - 각 행의 블록을 `strip()`하여 양쪽 공백을 제거한 뒤, 남아있는 문자열에서 공백의 개수를 세어 빈 공간 개수를 구한다.

4. **결과 출력**  
   - 모든 행의 빈 공간 개수를 합산하여 출력한다.

## 3. 회고

### +Solution

```python
H, W = map(int, input().split())
blocks = list(map(int, input().split()))

# 왼쪽과 오른쪽 최대값 배열 초기화
left_max = [0] * W
right_max = [0] * W

# 왼쪽 최대값 계산
left_max[0] = blocks[0]
for i in range(1, W):
    left_max[i] = max(left_max[i - 1], blocks[i])

# 오른쪽 최대값 계산
right_max[W - 1] = blocks[W - 1]
for i in range(W - 2, -1, -1):
    right_max[i] = max(right_max[i + 1], blocks[i])

# 빗물의 양 계산
ans = 0
for i in range(W):
    ans += max(0, min(left_max[i], right_max[i]) - blocks[i])

print(ans)
```
---
1. **왼쪽 최대값 배열 생성**:
   - `left_max[i]`는 `i`번째 열까지의 블록 중 가장 높은 블록의 높이를 저장합니다.
   - `left_max[i] = max(left_max[i-1], blocks[i])`.

2. **오른쪽 최대값 배열 생성**:
   - `right_max[i]`는 `i`번째 열부터 끝까지의 블록 중 가장 높은 블록의 높이를 저장합니다.
   - `right_max[i] = max(right_max[i+1], blocks[i])`.

3. **빗물의 양 계산**:
   - 각 열에서 빗물이 고일 수 있는 최대 높이는 `min(left_max[i], right_max[i])`입니다.
   - 현재 블록 높이(`blocks[i]`)보다 클 경우, 고이는 빗물의 양은 `min(left_max[i], right_max[i]) - blocks[i]`가 됩니다.
   - `max(0, ...)`를 사용해 음수가 되는 경우를 방지합니다.
---
시간복잡도
- 내가 푼 코드의 시간복잡도: O(h*w)
- 다음 코드: O(w)
---
### 유용한 라이브러리 or 메서드
