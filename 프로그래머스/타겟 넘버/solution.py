def dfs(num, numbers, cnt, target):
    if not numbers:
        if num == target:
            cnt += 1
            return cnt
        else:
            return 0
    else:
        cNumbers = numbers[:]
        nextNum = cNumbers.pop(0)
        a = dfs(num + nextNum, cNumbers, cnt, target)
        b = dfs(num - nextNum, cNumbers, cnt, target)

        return a + b

def solution(numbers, target):
    result = dfs(0, numbers, 0, target)
    return result