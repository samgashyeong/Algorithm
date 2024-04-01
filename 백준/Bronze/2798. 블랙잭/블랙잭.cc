#include <iostream>
#include <vector>
using namespace std;


int main() {
	int N;
	int M;
	vector<int> s;
	cin >> N;
	cin >> M;
	for (int i = 0; i < N; i++) {
		int temp;
		cin >> temp;
		s.push_back(temp);
	}
	int ans = M;
	int i, j, k;
	int result = 0;
	for (i = 0; i < N-2; i++) {
		for (j = i+1; j < N-1; j++) {
			for (k = j+1; k < N; k++) {
				if (s[i] + s[j] + s[k] <= M && M-(s[i] + s[j] + s[k]) < M- result) {
					result = s[i] + s[j] + s[k];
				}
			}
		}
	}
	cout << result;
}