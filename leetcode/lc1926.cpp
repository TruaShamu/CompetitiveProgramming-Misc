class Solution {
public:
    vector<int> dx = {-1, 0, 0, 1};
    vector<int> dy = {0, -1, 1, 0};
    int nearestExit(vector<vector<char>>& maze, vector<int>& entrance) {
        int N = maze.size();
        int M = maze[0].size();
        maze[entrance[0]][entrance[1]] = '+';
        queue<pair<pair<int, int>, int>> q;

        pair<pair<int, int>, int> start;
        start.first.first = entrance[0];
        start.first.second = entrance[1];
        start.second = 0;

        q.push(start);
        while (!q.empty()) {
            pair oPair = q.front();
            q.pop();
            for (int i=0; i< 4; i++) {
                pair next = oPair;
                next.first.first += dx[i];
                next.first.second += dy[i];
                next.second++;
                if (next.first.first >= 0 && next.first.first < N &&
                    next.first.second >= 0 && next.first.second < M &&
                    maze[next.first.first][next.first.second] != '+') {
                    // Check edge
                    if (next.first.first == 0 || next.first.first == N-1 
                        || next.first.second == 0 || next.first.second == M-1 ) {
                    return next.second;
                }
                maze[next.first.first][next.first.second] = '+';
                q.push(next);
                }
                
            }
        }
        return -1;

    }
};
