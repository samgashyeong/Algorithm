#include <iostream>
#include <stack>
using namespace std;


int main() {
	stack<double> s;
	int n;
	double arr[26];
	cin >> n;
	char str[101];
	cin >> str;

	for (int i = 0; i<n; i++) {
		cin >> arr[i];
	}
	for (int i = 0; str[i]!=NULL; i++) {
		if (str[i] >= 'A' && str[i] <= 'Z') {
			s.push(arr[str[i] - 'A']);
		}
		else {
			double b = s.top();
			s.pop();
			double a = s.top();
			s.pop();
			if (str[i] == '+') {
				s.push(a + b);
			}
			else if (str[i] == '-') {
				s.push(a - b);
			}
			else if (str[i] == '*') {
				s.push(a * b);
			}
			else if (str[i] == '/') {
				s.push(a / b);
			}
		}
	}
	cout<<fixed;
	cout.precision(2);
	cout << s.top();
}