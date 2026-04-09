#include <stdio.h>
#include <stdlib.h>


void ans(long long n) {

    if (n <= 0) {
        return;
    }

    long long left = n%2;
    ans(n/2);
    printf("%d", left);
}

int main() {

    long long n;
    scanf("%lld", &n);
    ans(n);
}