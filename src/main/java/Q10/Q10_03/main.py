n = int(input())
arr = list(map(int, input().split()))

dy = [1]
answer = 0
for i in range(1, len(arr)):
    max_num = 0
    for j in range(i-1, -1,-1):
        if (arr[j] < arr[i]) & (dy[j] > max_num):
            max_num = dy[j]
    dy.insert(i, max_num + 1)
    answer = max(answer, dy[i])

print(answer)
