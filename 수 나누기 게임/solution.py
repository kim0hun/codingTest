n = int(input())
player_card = list(map(int, input().split()))

player_card_dict = {card: idx for idx, card in enumerate(player_card)}
max_card = max(player_card)

result = [0] * n

for i in range(n):
    card = player_card[i]
    for j in range(card*2, max_card+1, card):
        if j in player_card_dict.keys():
            idx = player_card_dict[j]
            result[i] += 1
            result[idx] -= 1

for i in result:
    print(i, end=' ')