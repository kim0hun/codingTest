def convertFunc(f):
    dic = {'ds': 0, 'de': 0, 'r': False}

    for v in f:
        if v == 'R':
            dic['r'] = not dic['r']
        else:
            if dic['r'] == False:
                dic['ds'] += 1
            else:
                dic['de'] += 1
    return dic

t = int(input())

result = []
for _ in range(t):
    f = input()
    n = int(input())
    arr = list(map(int, input().replace('[', ' ').replace(']', ' ').replace(',', ' ').split()))
    
    dic = convertFunc(f)
    if dic['ds'] + dic['de'] > len(arr):
        result.append('error')
    else:
        if dic['de']:
            arr = arr[dic['ds']: -dic['de']]
        else:
            arr = arr[dic['ds']:]
        
        if dic['r']:
            arr = list(reversed(arr))

        result.append('[' + ','.join(list(map(str, arr))) + ']')

for v in result:
    print(v)