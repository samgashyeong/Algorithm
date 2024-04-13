N = int(input())
arr = []
f = 0
for i in range(N):
  tmp = int(input())
  if(tmp==0):
    del arr[f-1]
    f-=1
  else:
    arr.append(tmp)
    f+=1

print(sum(arr))