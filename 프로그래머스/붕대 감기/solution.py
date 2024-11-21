def solution(bandage, health, attacks):
    attackLength = attacks[-1][0]
    maxHealth = health
    attackCount = 0
    bandageCount = 0
    for time in range(attackLength+1):
        if attacks[attackCount][0] == time:
            health -= attacks[attackCount][1]
            attackCount += 1
            bandageCount = 0
        else:
            if health != maxHealth:
                health += bandage[1]
                bandageCount += 1
                if bandageCount == bandage[0]:
                    health += bandage[2]
                    bandageCount = 0
                if health > maxHealth:
                    health = maxHealth
        if health <= 0:
            return -1
    
    return health