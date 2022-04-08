def find(parent, x):
    if parent[x] == x:
        return x
    else:
        parent[x] = find(parent, parent[x])
        return parent[x]


def union(parent, a, b):
    a = find(parent, a)
    b = find(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b


# 노드의 개수와 간선의 개수 입력 받기
v, e = map(int, input().split())
parent = [i for i in range(0, v + 1)]

edges = []
result = 0

for i in range(e):
    a, b, cost = map(int, input().split())
    edges.append((cost, a, b))

# edges.sort(key=lambda element: element[0])
edges.sort()

for edge in edges:
    cost, a, b = edge
    if find(parent, a) != find(parent, b):
        union(parent, a, b)
        result += cost

print(result)
