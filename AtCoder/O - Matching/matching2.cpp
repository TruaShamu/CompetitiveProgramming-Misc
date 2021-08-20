/* ATCODER O - Matching(Recursion Sol) (DP on Bitmasks) */

#include <bits/stdc++.h>
#include <algorithm>
#include <cstddef>
typedef long long ll;
using namespace std;
int N;
int mod = (int)1e9 + 7;
bool comp [21][21];
long dp[21][1 << 21];

//#available men, #available women
 long long solve(int men, int women) {
    long long curAns = 0;

    //Already have value
    if (dp[men - 1][women] != -1) {
        return dp[men - 1][women];
    }

    if (men == 1) {
        for (int j = 0; j < N; j++) {
            //Check if the jth women is left.
            if (((1 << j) & women) > 0) {
                if (comp[men - 1][j]) {
                    //1 way to pair the last man with the woman if they're compatible.
                    dp[men - 1][women] = 1;
                    return 1;
                }
                else {
                    dp[N - 1][women] = 0;
                    return 0;
                }
            }
        }
    }

    for (int i = 0; i < N; i++) {
        //If the ith woman is available.
        if (((1 << i) & women) > 0) {
            if (comp[men - 1][i]) {
                //Recursively calculate the # ways, if the man is paired with this woman.
                curAns += solve(men - 1, women - (1 << i));
            }
        }
    }
    //MOD IT.
    curAns %= mod;
    dp[men - 1][women] = curAns;
    return dp[men - 1][women];
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;

    for (int i = 0; i < 21; i++) {
        for (int j = 0; j < 1 << 21; j++) {
            dp[i][j] = -1;
        }
    }

    // Compatibility matrix from the input.
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> comp[i][j];
        }
    }

    long long answer = solve(N, (1 << N) - 1);


    cout << answer << "\n";
}


