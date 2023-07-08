package daily_problems;

import java.util.Arrays;

public class SetMatrixZeroes73 {
    public static void main(String[] args) {
    }

    static class Solution {
        public void setZeroes(int[][] matrix) {
            //I need to do it in place
            //Can't allocate new space to record the orginal 0 and modified 0
            //Need to find a flag which can be placed in orignal matrix without mixing the whole
            //The flag has to satisfy 2 properties: 1.Won't mislead 2.Having generality
            boolean setCol = false;

            //the first step is iterating the matrix and set the flag
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][0] == 0) {
                    setCol = true;
                }
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
            //iterate over the first row and first colmun set the cooresponding cell as 0

            //At the first time, there wase a mistake which mixies the modified 0 and original 0.And I would have thought this algorithm didn't have this bug.
            //check every row
            for (int i = 1; i < matrix.length; i++) {
                if (matrix[i][0] == 0) {
                    for (int j = 1; j < matrix[0].length; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }

            //check every colmun
            for (int i = 1; i < matrix[0].length; i++) {
                if (matrix[0][i] == 0) {
                    for (int j = 1; j < matrix.length; j++) {
                        matrix[j][i] = 0;
                    }
                }
            }

            if (matrix[0][0] == 0) {
                for (int i = 0; i < matrix[0].length; i++) {
                    matrix[0][i] = 0;
                }
            }

            if (setCol) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][0] = 0;
                }
            }
        }
    }
}
