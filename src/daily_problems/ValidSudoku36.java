package daily_problems;

import java.util.HashSet;

public class ValidSudoku36 {
    public static void main(String[] args) {
        char[][] test = {{'.', '8', '7', '6', '5', '4', '3', '2', '1'},{'2', '.', '.', '.', '.', '.', '.', '.', '.'},{
        '3', '.', '.', '.', '.', '.', '.', '.', '.'},{'4', '.', '.', '.', '.', '.', '.', '.', '.'},{
        '5', '.', '.', '.', '.', '.', '.', '.', '.'},{'6', '.', '.', '.', '.', '.', '.', '.', '.'},{
        '7', '.', '.', '.', '.', '.', '.', '.', '.'},{'8', '.', '.', '.', '.', '.', '.', '.', '.'},{
        '9', '.', '.', '.', '.', '.', '.', '.', '.'}};

        Solution solution = new Solution();
        boolean result = solution.isValidSudoku(test);
        System.out.println(result);

    }

    static class Solution {
        public boolean isValidSudoku(char[][] board) {
            //initialize the hashset. for each row, column, box, they have one hashset
            HashSet<Character>[] rows = new HashSet[9];
            HashSet<Character>[] columns = new HashSet[9];
            HashSet<Character>[] boxes = new HashSet[9];
            for (int i = 0; i < 9; i++) {
                rows[i] = new HashSet<Character>();
                columns[i] = new HashSet<Character>();
                boxes[i] = new HashSet<Character>();
            }
            //because the data layout in memory is linear, it has better locality of putting accesssing rows in inner
            for (int j = 0; j < 9; j++) {
                for (int i = 0; i < 9; i++) {
                    char val = board[j][i];
                    if (val == '.') {
                        continue;
                    }
                    if (rows[j].contains(val)) {
                        return false;
                    }
                    rows[j].add(val);
                    if (columns[i].contains(val)) {
                        return false;
                    }
                    columns[i].add(val);
                    int index = (j / 3) * 3 + i / 3;
                    if (boxes[index].contains(val)) {
                        return false;
                    }
                    boxes[index].add(val);
                }
            }
            return true;
        }
    }
}
