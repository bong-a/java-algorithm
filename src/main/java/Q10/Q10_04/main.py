n = int(input())
arr = []
for i in range(n):
    temp = list(map(int, input().split()))
    arr.append(temp)

arr = sorted(arr,key=lambda a:a[0])
dy = [arr[0][1]]
answer = 0
for i in range(1, len(arr)):
    max_num = 0
    for j in range(i-1, -1,-1):
        if (arr[j][2] < arr[i][2]) & (dy[j] > max_num):
            max_num = dy[j]
    dy.insert(i, max_num + arr[i][1])
    answer = max(answer, dy[i])

print(answer)
