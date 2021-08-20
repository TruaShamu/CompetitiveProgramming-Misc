/* Here's to hoping that I actually understood this correctly and didn't accidentally fuck something up.*/

/* ATCODER O - Matching(No Recursion Sol) (DP on Bitmasks) */

#include <bits/stdc++.h>
typedef long long ll;
using namespace std;
const int MOD = 1e9 + 7;
const int MAXN = 21;
bool comp[MAXN][MAXN];
int dp[1 << MAXN];

/* Because I can't get __builtin_popcount() to work on visual studio */
unsigned int countSetBits(unsigned int n) {
    unsigned int count = 0;
    while (n) {
        count += n & 1;
        n >>= 1;
    }
    return count;
}



int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int N;
    cin >> N;

    // Compatibility matrix from the input.
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> comp[i][j];
        }
    }

    dp[0] = 1;
    // Bitmask - 0 means paired, 1 means available.
    for (int mask = 0; mask < (1 << N); mask++) {
        /* The current woman.
        If there are 7 people, 2 are available, then this means that we are currently on
        the 6th person (the 1st available one), but since it's indexed by 0, so we are on the 5th person??? I think???
        */
        int now = N - countSetBits(mask);
        // Now loop through each man to match it with
        for (int i = 0; i < N; i++) {
            // The man is available and compatible
            if ((mask & (1 << i)) > 0 && comp[now][i] == 1) {
                // Add the value from when the man is not compatible.
                dp[mask] = (dp[mask] + dp[mask ^ (1 << i)]) % MOD;
            }
        }
    }

    cout << dp[(1 << N) - 1] << "\n";
}


