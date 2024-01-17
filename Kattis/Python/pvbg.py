n = int(input())
peashooters = list(map(int, input().split()))

min_wave = 0
bad_guys = min_wave
temp = 100000

for peashooter_count in peashooters:
    min_wave += 1
    if peashooter_count < temp:
        temp = peashooter_count

min_wave = temp + 1
    

print(min_wave)
