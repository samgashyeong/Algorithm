N = int(input())
li = sorted(list(map(int, input().split())))
ans = 0
for i in range(N):
    ans += sum(li[:i+1])
print(ans)