package daily_problems;

public class Searcha2DMatrix74 {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},
                          {10,11,16,20},
                          {23,30,34,60}};
        Solution solution = new Solution();
        boolean b = solution.searchMatrix(matrix, 11);
        System.out.println(b);
    }

    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            //binary search over rows
            int up = 0;
            int down = matrix.length - 1;
            while (up < down) {
                if (target == matrix[up][0] || target == matrix[down][0]) {
                    return true;
                }
                if (target > matrix[up][0] && target < matrix[down][0] && down - up == 1) {
                    break;
                }
                int middle = (down + up)/2;
                if (target == matrix[middle][0]) {
                    return true;
                }
                if (target > matrix[middle][0]) {
                    up = middle+1;
                } else if (target < matrix[middle][0]) {
                    down = middle-1;
                }
                if (matrix[middle][matrix[0].length - 1] >= target && up > middle) {
                    up = middle;
                }
            }
            //binary search over the potential row
            if (up > down) {
                return false;
            }
            int right = 0;
            int left = matrix[0].length-1;
            while (right <= left) {
                int middle = (left+right)/2;
                if (target == matrix[up][middle]) {
                    return true;
                }
                if (target > matrix[up][middle]) {
                    right = middle + 1;
                } else if (target < matrix[up][middle]) {
                    left = middle - 1;
                }
            }
            return false;
        }
    }
}
