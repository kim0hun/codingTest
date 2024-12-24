# 올바른 괄호 문자열 확인 함수
def checkRightString(p):
    check = 0
    for v in p:
        if v == '(':  # 여는 괄호일 경우 카운트를 증가
            check += 1
        else:  # 닫는 괄호일 경우 카운트를 감소
            check -= 1
        if check < 0:  # 중간에 닫는 괄호가 더 많아지는 경우 False
            return False
    return check == 0  # 모든 괄호가 짝지어진 경우 True

# 올바른 괄호 문자열로 변환 함수
def convert(p):
    # 1. 빈 문자열이면 그대로 반환
    if p == '':
        return p

    # 2. "균형잡힌 문자열" u와 나머지 v로 분리
    check = 0
    for i in range(len(p)):
        if p[i] == '(':
            check += 1
        else:
            check -= 1
        if check == 0:  # 균형이 맞는 순간
            u = p[:i+1]
            v = p[i+1:]
            break

    # 3. u가 올바른 괄호 문자열인지 확인
    if checkRightString(u):
        return u + convert(v)  # v에 대해 재귀 호출
    else:
        # 4. 올바른 문자열로 변환
        new = ''
        for c in u[1:-1]:  # u의 첫 번째와 마지막 문자를 제거하고 뒤집기
            if c == '(':
                new += ')'
            else:
                new += '('
        return f'({convert(v)}){new}'

# 주어진 문자열 p를 올바른 괄호 문자열로 변환하는 함수
def solution(p):
    if checkRightString(p):  # 이미 올바른 괄호 문자열인 경우 그대로 반환
        return p
    else:
        return convert(p)
