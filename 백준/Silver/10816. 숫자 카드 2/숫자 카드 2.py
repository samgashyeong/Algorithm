from sys import stdin
from collections import Counter

n = int(stdin.readline())

arr = list(map(int, stdin.readline().split()))

m = int(stdin.readline())

find = list(map(int, stdin.readline().split()))

count = Counter(arr)

print(' '.join(str(count[x]) if x in count else '0' for x in find))