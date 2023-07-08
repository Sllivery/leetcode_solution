package daily_problems;

import java.util.*;

public class UniquePaths62 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.uniquePaths(3, 2);
        System.out.println(i);
    }

    static class Solution {
        public int myUniquePaths(int m, int n) {
            //LTE
            int[][] directions = {{1, 0}, {0, 1}};
            int result = 0;
            Queue<int[]> queue = new LinkedList<>();
            HashSet<String> visited = new HashSet<>();
            queue.add(new int[] {0,0});
            while (!queue.isEmpty()) {
                int[] currentPosition = queue.poll();
                if (currentPosition[0] == m-1 && currentPosition[1] == n-1) {
                    result++;
                    continue;
                }
                for (int[] direction : directions) {
                    int[] newPosition = {currentPosition[0] + direction[0], currentPosition[1] + direction[1]};
                    String stringPosition = Integer.toString(newPosition[0]) + Integer.toString(newPosition[1]);
                    if (newPosition[0] < m && newPosition[0] >= 0 && newPosition[1] < n && newPosition[1] >= 0){
                        queue.add(newPosition);
                    }
                }
            }
            return result;
        }

        public int uniquePaths(int m, int n) {
            int[][] map = new int[m][n];

            for (int[] ints : map) {
                Arrays.fill(ints, 1);
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    map[i][j] = map[i - 1][j] + map[i][j - 1];
                }
            }

            return map[m - 1][n - 1];
        }
    }
}
