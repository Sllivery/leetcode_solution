package daily_problems;

public class wordSearch79 {
    public static void main(String[] args) {
        char[][] test = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String testWord = "ABCESEEEFS";
        Solution solution = new Solution();
        boolean exist = solution.exist(test, testWord);
        System.out.println(exist);
    }

    static class Solution {
        private boolean[][] start;

        public boolean exist(char[][] board, String word) {
            //这题难在，矩阵的搜索空间是巨大的,但是如果用回溯，那是不是可以，很有希望，试一试
            //有个不用HashMap的记录方式，创建一个和board一样的数组record，走过的地方把record对应的索引赋值为1
            int width = board.length;
            int length = board[0].length;
            if (width * length < word.length()) {
                return false;
            }
            start = new boolean[width][length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0) && backtrack(i, j, 0, board, word)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean backtrack(int i, int j, int index, char[][] board, String word) {
            //find the string
            if (index == word.length()) {
                return true;
            }
            //out of bound or visited or the current char is inequal to board
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || start[i][j] || word.charAt(index) != board[i][j]) {
                return false;
            }
            //一个节点拖出四个子节点，因为有四个方向
            boolean result = false;
            start[i][j] = true;
            if (
                    backtrack(i + 1, j, index + 1, board, word) ||
                    backtrack(i - 1, j, index + 1, board, word) ||
                    backtrack(i, j + 1, index + 1, board, word) ||
                    backtrack(i, j - 1, index + 1, board, word)
            ) {
                result = true;
            }
            start[i][j] = false;
            return result;
        }

    }
}
