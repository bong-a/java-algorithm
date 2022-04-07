n,total = list(map(int, input().split()))
arr = []
for i in range(n):
    temp = list(map(int, input().split()))
    arr.append(temp)
dy = []
for i in range(0,total+1):
    dy.append(0)

for c in arr:
    num = 0
    for j in range(total, c[1] - 1, -1):
        cnt = dy[j - c[1]] + c[0]
        dy[j] = max(dy[j], cnt)

print(dy[total])
