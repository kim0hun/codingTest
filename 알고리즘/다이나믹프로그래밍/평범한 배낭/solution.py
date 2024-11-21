# def cal(K, W, sumSet, resultList):
#     nothing = True
#     for i in range(len(W)):
#         copyW = list.copy(W)
#         copySumSet = set.copy(sumSet)
#         if K >= W[i]:
#             nothing = False
#             copySumSet.add(copyW[i])
#             copyW.pop(i)
#             cal(K-W[i], copyW, copySumSet, resultList)
            
#     if nothing and sumSet not in resultList:
#         resultList.append(sumSet)

# i1 = input().split(' ')
# N, K = int(i1[0]), int(i1[1])

# W = []
# V = {}

# for _ in range(N):
#     i2 = input().split()
#     W.append(int(i2[0]))
#     V[int(i2[0])] = int((i2[1]))

# resultList = []
# s = set()

# # for i in range(len(W)):

# # cal(K, W, s, resultList)
# print(resultList)

# max = 0
# for setList in resultList:
#     sum = 0
#     for v in setList:
#         sum += V[v]
#     if max < sum:
#         max = sum

# print(max)

##################################

from itertools import combinations

N, K = map(int, input().split(' '))

WV = {}

for _ in range(N):
    W, V = map(int, input().split())
    if W in WV.keys() and WV[W] > V:
        continue
    else:
        WV[W] = V

max = 0
for i in range(1, len(WV.keys())+1):
    for x in combinations(WV.keys(), i):
        if sum(x) <= 7:
            valueSum = 0
            for y in x:
                valueSum += WV[y]
            if valueSum > max:
                max = valueSum
                
print(max)

##################################

