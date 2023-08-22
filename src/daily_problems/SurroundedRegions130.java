package daily_problems;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions130 {
    public static void main(String[] args) {
        char[][] test = {{'O','O','O','O','X','X'},
                         {'O','O','O','O','O','O'},
                         {'O','X','O','X','O','O'},
                         {'O','X','O','O','X','O'},
                         {'O','X','O','X','O','O'},
                         {'O','X','O','O','O','O'}};
        Solution solution = new Solution();
        solution.solve(test);
        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test[0].length; j++) {
                System.out.print(test[i][j] + " ");
            }
            System.out.println();
        }
    }

    static class Solution {
        public void solve(char[][] board) {
            //i row
            //j column
            int[][] visited = new int[board.length][board[0].length];
            Queue<int[]> modified = new LinkedList<>();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    //if char == 'O' -> judge whether it's four directions are all 'X'
                    if (visited[i][j] != 1 && board[i][j] == 'O' && i > 0 && j > 0 && i < board.length - 1 && j < board[0].length - 1) {
                        //cuz the loop order is from left to right, up to down
                        //so there's no need to check left element. Direction list would be [right, down]
                        if (helper(i, j + 1, board, visited, modified) && helper(i + 1, j, board, visited, modified)){
                            board[i][j] = 'X';
                        }
                    }
                    visited[i][j] = 1;
                }
            }
        }

        public boolean helper(int i, int j, char[][] board, int[][] visited, Queue<int[]> modififed) {
            visited[i][j] = 1;
            if (board[i][j] == 'X') {
                return true;
            }

            if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) {
                return false;
            }

            if (helper(i, j + 1, board, visited, modififed) && helper(i + 1, j, board, visited, modififed)) {
                board[i][j] = 'X';
                modififed.add(new int[]{i, j});
                return true;
            } else {
                if (!modififed.isEmpty()) {
                    int[] poll = modififed.poll();
                    board[poll[0]][poll[1]] = 'O';
                }
                return false;
            }
        }
    }
}
