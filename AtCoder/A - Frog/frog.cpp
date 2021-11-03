#include <bits/stdc++.h>
#include <stdio.h>
#include <stdlib.h> 
using namespace std;
const int MAXN = 1e5 + 5;
int main() {
	int N;
	int A[MAXN];
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> A[i];
	}
 
	int dp[MAXN];
	for (int i = 0; i < MAXN; i++) {
		dp[i] = 1e9;
	}
	dp[0] = 0;
	for (int i = 0; i < N; i++) {
		if (i > 0) {
			dp[i] = min(dp[i], dp[i - 1] + abs(A[i] - A[i - 1]));
		}
		if (i > 1) {
			dp[i] = min(dp[i], dp[i - 2] + abs(A[i] - A[i - 2]));
		}
	}
 
	cout << dp[N - 1] << "\n";
 
}
