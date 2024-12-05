def solution(record):
    currentNickname = {}
    inoutRecord = []
    result = []
    
    for eachRecord in record:
        arr = eachRecord.split()
        if len(arr) == 3:
            currentNickname[arr[1]] = arr[2]
        if arr[0] == 'Enter' or arr[0] == 'Leave':
            inoutRecord.append((arr[1], arr[0]))
    
    for uid, inout in inoutRecord:
        if inout == 'Enter':
            result.append(currentNickname[uid] + '님이 들어왔습니다.')
        else:
            result.append(currentNickname[uid] + '님이 나갔습니다.')
    
    return result