package daily_problems;

public class wordSearch79 {
    public static void main(String[] args) {
        char[][] test = {
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}
        };
        String testWord = "ABCESEEEFS";
        Solution solution = new Solution();
        boolean exist = solution.exist(test, testWord);
        System.out.println(exist);
    }

    static class Solution {
        private final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public boolean exist(char[][] board, String word) {
            //这题难在，矩阵的搜索空间是巨大的,但是如果用回溯，那是不是可以，很有希望，试一试
            //有个不用HashMap的记录方式，创建一个和board一样的数组record，走过的地方把record对应的索引赋值为1
            int width = board.length;
            int length = board[0].length;
            if (width * length < word.length()) {
                return false;
            }
            int[][] start = new int[board.length * board[0].length][];
            int index = 0;
            boolean[] flag = {false};
            for (int i = 0; i < board.length; i++) {
                if (flag[0]) break;
                for (int j = 0; j < board[0].length; j++) {
                    if (flag[0]) break;
                    if (board[i][j] == word.charAt(0)){
                        StringBuilder result = new StringBuilder();
                        int[][] record = new int[board.length][board[0].length];
                        int[] currentPosition = {i, j};
                        result.append(board[i][j]);
                        backtrack(result, board, word, flag, record, currentPosition);
                    }
                }
            }
            return flag[0];
        }

        private void backtrack(StringBuilder builder, char[][] board, String word, boolean[] flag, int[][] record, int[] currentPosition) {
            String current = builder.toString();
            int currLength = current.length();
            if (currentPositionisVisited(record, currentPosition) || currentPositionMismatched(word, builder)) {
                return;//这是失败标志
            }
            if (currLength == word.length() && current.charAt(currLength - 1) == word.charAt(word.length() - 1)) {
                record[currentPosition[0]][currentPosition[1]] = 1;
                flag[0] = true;//这是成功标志
                return;
            }
            record[currentPosition[0]][currentPosition[1]] = 1;
            //一个节点拖出四个子节点，因为有四个方向
            for (int[] direction : directions) {
                int x = currentPosition[1] + direction[1];
                int y = currentPosition[0] + direction[0];
                int[] newPosistion = {y, x};
                if (x >= 0 && x < board[0].length && y >= 0 && y < board.length) {
                    builder.append(board[y][x]);
                    backtrack(builder, board, word, flag, record, newPosistion);
                    record[newPosistion[0]][newPosistion[1]] = 0;
                    builder.deleteCharAt(builder.length() - 1);
                }
            }
        }

        private boolean currentPositionisVisited(int[][] record, int[] currentPosition) {
            return record[currentPosition[0]][currentPosition[1]] == 1;
        }

        private boolean currentPositionMismatched(String word, StringBuilder builder) {
            return word.charAt(builder.length() - 1) != builder.charAt(builder.length() - 1);
        }
    }
}
