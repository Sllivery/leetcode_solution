package microsoft_q.arrays_strings;

public class RotateImage {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] m = {{1,2,3},{4,5,6},{7,8,9}};
        solution.rotate(m);
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.println(m[i][j]);
            }
        }
    }

    static class Solution{
        public void rotate(int[][] matrix) {
            int l = 0, t = 0;
            int r = matrix.length - 1, b = matrix[0].length;
            while ( l < r ){
                for (int i = 0; i < r - 1; i++) {
                    t = l;
                    b = r;
                    //top left
                    int temp = matrix[t][l + i];
                    //bottom left -> top left
                    matrix[t][l + i] = matrix[b - i][l];
                    //bottom right -> bottom left
                    matrix[b - i][l] = matrix[b][r - i];
                    //top right -> bottom right
                    matrix[b][r - i] = matrix[t + i][r];
                    //top left -> top right
                    matrix[t + i][r] = temp;
                }
                l += 1;
                r -= 1;
            }
        }
    }
}
