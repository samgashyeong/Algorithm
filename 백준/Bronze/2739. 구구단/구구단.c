
#include <stdio.h>
#include <stdlib.h>


void ans(int n, int i) {

    if (i == 10) {
        return;
    }

    printf("%d * %d = %d\n", n, i, n * i);
    ans(n, i+1);
}

int main() {

    int n;
    scanf("%d", &n);
    ans(n, 1);
}