#include<iostream>
using namespace std;
int main() {
    int d[1001] = { 0, };
    int n = 0;
    cin >> n;
    d[1] = 1;
    d[2] = 2;
    for (int i = 3; i <= n; i++)
        d[i] = (d[i - 2] + d[i - 1]) % 10007;
    cout << d[n];
}