import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int N;
    public List<List<String>> solveNQueens(int len) {
        N = len;

        //Fill grid with empty.
        char[][] grid = new char[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(grid[i], '.');
        }

        List<List<String>> res = new ArrayList<>();
        recurse(grid, 0, res);

        return res;
    }

    public void recurse(char[][] grid, int R, List<List<String>> result) {
        if (R == N) {
            result.add(gridString(grid));
            return;
        }

        for (int C = 0; C < N; C++) {
            if (works(grid, R, C)) {
                grid[R][C] = 'Q';
                recurse(grid, R + 1, result);
                grid[R][C] = '.';
            }
        }
    }

    public boolean works(char[][] grid, int R, int C) {
        //same column
        for (int i = R - 1; i >= 0; i--) {
            if (grid[i][C] == 'Q') {
                return false;
            }
        }

        // upper-left diagonal
        for (int i = R - 1, j = C - 1; (i >= 0 && j >= 0); i--, j--) {
            if (grid[i][j] == 'Q') {
                return false;
            }
        }

        // upper-right diagonal
        for (int i = R - 1, j = C + 1; i >= 0 && j < N; i--, j++) {
            if (grid[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public ArrayList<String> gridString(char[][] grid) {
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            res.add(new String(grid[i]));
        }
        return res;
    }
}
