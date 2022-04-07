n = int(input())
arr = list(map(int, input().split()))
m = int(input())


dy = []
for i in range(0,m+1):
    dy.append(i)

for c in arr:
    num = 0
    for j in range(c,len(dy)):
        cnt = dy[j-c]+1
        if dy[j] > cnt:
            dy[j] = cnt

print(dy[len(dy)-1])
