n = int(input())
dy = [0,1,2]

for i in range(3,n+2):
    dy.append(dy[i-2]+dy[i-1])
print(dy[n+1])