import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Given an m x n grid of characters board and a string word, return true if
 * word exists in the grid
 * The word can be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 */
class Solution {

    public boolean exist(char[][] board, String word) {
        int N = board.length;
        int M = board[0].length;
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (word.charAt(0) == board[i][j]) {
                    Arrays.stream(visited).forEach(a -> Arrays.fill(a, false));
                    if (solveFromIndex(board, word, visited, i, j, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean solveFromIndex(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        int N = board.length;
        int M = board[0].length;
        int[] x_move = { 1, -1, 0, 0 };
        int[] y_move = { 0, 0, 1, -1 };

        if (index + 1 == word.length()) {
            return true;
        }

        visited[i][j] = true;

        for (int k = 0; k < 4; ++k) {
            int new_i = i + x_move[k];
            int new_j = j + y_move[k];

            if (0 <= new_i && new_i < N &&
                    0 <= new_j && new_j < M &&
                    !visited[new_i][new_j] && word.charAt(index + 1) == board[new_i][new_j]) {

                boolean ans = solveFromIndex(board, word, visited, new_i, new_j, index + 1);
                if (ans) {
                    return true;
                }
                visited[new_i][new_j] = false;
            }
        }

        return false;
    }

}