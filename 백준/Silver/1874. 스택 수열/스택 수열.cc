#include<iostream>
#include<stack>
#include<string>
#include<vector>

using namespace std;

int main(void) {
	stack<int> stk;
	vector<char> output;
	int n;
	int cnt = 1;
	
	cin >> n;
	
	for(int i =0;i<n;i++){
		int tmp;
		cin >> tmp;
		
		while(cnt<=tmp){
			stk.push(cnt);
			cnt+=1;
			output.push_back('+');
		}
		if(stk.top() == tmp){
			stk.pop();
			output.push_back('-');
		}
		else{
			cout<<"NO";
			return 0;
		}
	}
	for(int i = 0;i<output.size();i++){
		cout<<output[i]<<"\n";
	}
    return 0;
}