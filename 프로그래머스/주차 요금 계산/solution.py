from collections import defaultdict
from math import ceil

def solution(fees, records):
    temp = {}
    parkingTime = defaultdict(int)
    
    for record in records:
        # 변수 할당
        arr = record.split()
        hour, minute = map(int, arr[0].split(':'))
        carNumber = arr[1]
        inout = arr[2]
        
        # IN이면 temp 딕셔너리에 입장 시간(분단위) 저장, OUT이면 시간 계산 후 parkingTime에 저장 + temp에 -1로 설정
        if inout == 'IN':
            temp[carNumber] = hour * 60 + minute
        else:
            parkingTime[carNumber] += hour * 60 + minute - temp[carNumber]
            temp[carNumber] = -1
    
    # 입차 후 출차하지 않은 차량 시간 계산
    for carNumber, time in temp.items():
        if time != -1:
            parkingTime[carNumber] += 23 * 60 + 59 - time
    
    # 요금 계산
    answer = []
    for key in sorted(parkingTime.keys()):
        if parkingTime[key] - fees[0] > 0:
            answer.append(fees[1] + ceil(((parkingTime[key] - fees[0]) / fees[2])) * fees[3])
        else:
            answer.append(fees[1])
    
    return answer