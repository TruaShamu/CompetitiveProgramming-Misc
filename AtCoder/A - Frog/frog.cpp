
#include <bits/stdc++.h>
using namespace std;

#define ll long long
#define pb push_back
#define pi pair<int, int>
#define vi vector<int>
#define vvi vector<vi>
void set_io(string s) {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    freopen((s + ".in").c_str(), "r", stdin);
    freopen((s + ".out").c_str(), "w", stdout);
}

const int t = 1005;

int n, cd, m;
vvi adj_list(1001);
vi money(1001, 0);
vvi dp(t + 1, vi(1001, -1));
int ans(0);

int main() {
    set_io("time");

    cin >> n >> m >> cd;

    for (int i = 1; i <= n; i++) {
        int x;
        cin >> x;

        money[i] = x;
    }

    for (int i = 1; i <= m; i++) {
        int x, y;
        cin >> x >> y;
        adj_list[x].pb(y);
    }

    dp[0][1] = 0;

    for (int r = 0; r < t; r++) {
        for (int c = 1; c <= n; c++) {
            if (dp[r][c] == -1) {
                continue;
            }
            if (c == 1) {
                ans = max(ans, dp[r][c] - cd * r * r);
            }
            for (auto v : adj_list[c]) {
                 dp[r + 1][v] = max(dp[r + 1][v], dp[r][c] + money[v]);
            }
        }
    }

    cout << ans;

}
