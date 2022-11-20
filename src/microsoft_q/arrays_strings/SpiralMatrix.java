package microsoft_q.arrays_strings;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> result = solution.spiralOrder(matrix);
        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }
}

class Solution {
    //wrong
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        driver(matrix, matrix.length, matrix[0].length, result, 0, 0);
        return result;
    }
    //wrong
    private void driver(int[][] matrix, int m, int n, List<Integer> result, int i, int j) {
        int beginI = i;
        int beginJ = j;
        //special
        if (i == m && j == n) {
            result.add(matrix[i][j]);
        }
        //1'
        while (i < m && j < n) {
            result.add(matrix[i][j++]);
        }
        j--;
        i++;
        //2'
        while (i < m && j == n - 1) {
            result.add(matrix[i++][j]);
        }
        i--;
        j--;
        //3'
        while (i == n - 1 && j >= beginJ) {
            result.add(matrix[i][j--]);
        }
        j++;
        i--;
        //4'
        while (j == 0 && i >= beginI) {
            result.add(matrix[i--][j]);
        }
        if (m == 1) {
            return;
        }
        driver(matrix, m - 2, n - 2, result, i + 1, j + 1);
    }

    public List<Integer> spiralOrderReference(int[][] matrix){
         ArrayList<Integer> result = new ArrayList<>();
//        int up = 0;
//        int down = 0;
//        int row = matrix.length - 1;
//        int col = matrix[0].length - 1;
//        while (result.size() < matrix.length * matrix[0].length) {
//            //left to right
//            for (int colIndex = )
//            //up to bottom
//            //right to left
//            //bottom to up
//        }
         return result;
    }
}
