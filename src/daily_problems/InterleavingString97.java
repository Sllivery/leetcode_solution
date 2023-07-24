package daily_problems;

public class InterleavingString97 {
    //todo
    public static void main(String[] args) {

    }

    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            //What a simpler problem can be converted from the origianl one?
            //Given two strings, which can be viewed as trying all possible permutation to looking for s3
            //All problem like searching, can be done with brute force

            //Here's the solution
            if (s1.length() + s2.length() != s3.length()) {
                return false;
            }
            //Initialize a 2d array for respresenting the result of current s1, s2 combination
            boolean[][] matrix = new boolean[s1.length()+1][s2.length()+1];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = false;
                }
            }
            //set a basic case
            matrix[s1.length()][s2.length()] = true;
            //perform dp.from bottom to top
            for (int i = s1.length(); i >= 0; i--) {
                for (int j = s2.length(); j >= 0; j--) {
                    if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j) && matrix[i + 1][j]) {
                        matrix[i][j] = true;
                    }
                    if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j) && matrix[i][j + 1]) {
                        matrix[i][j] = true;
                    }
                }
            }
            return matrix[0][0];
        }
    }
}
