def DFS(L, sum, check, cost, arr, answer):
    if L == (len(cost) - 1):
        all_visit = True
        for a in range(len(check)):
            if check[a] == 0:
                all_visit = False
        if all_visit:
            answer.append(sum)
    else:
        for a in range(1, len(cost)):
            if check[a] == 0:
                discount_map = arr[a]
                copy = [0 for k in range(len(cost))]
                for discount_info in discount_map:
                    idx = discount_info[0]
                    discount = discount_info[1]
                    if (check[idx] == 1) | (idx == a) | (discount == 0):
                        continue
                    copy[idx] = cost[idx]
                    cost[idx] = (cost[idx] - discount)
                    if cost[idx] <= 0:
                        cost[idx] = 1
                check[a] = 1
                DFS(L + 1, sum + cost[a], check, cost, arr, answer)
                check[a] = 0
                for b in range(len(copy)):
                    if copy[b] != 0:
                        cost[b] = copy[b]


def solution(cost, arr):
    check = [0 for i in range(len(cost))]
    check[0] = 1
    answer = []
    DFS(0, 0, check, cost, arr, answer)
    return min(answer)


n = int(input())
cost = list(map(int, input().split()))
cost.insert(0, 0)
arr = [[]]

for i in range(n):
    m = int(input())
    a = []
    for j in range(0, m):
        temp = list(map(int, input().split()))
        a.append(temp)
    arr.append(a)
answer = solution(cost, arr)
print(answer)
