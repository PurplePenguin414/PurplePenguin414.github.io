nums = int(input())

evenOrOdd = []
array = []

for i in range(nums):
    array.append(int(input()))
    temp = array[i] % 2
    if temp != 0:
        evenOrOdd.append(False)
    else:
        evenOrOdd.append(True)

for j in range(nums):
    if not evenOrOdd[j]:
        print(array[j], "is odd")
    else:
        print(array[j], "is even")
