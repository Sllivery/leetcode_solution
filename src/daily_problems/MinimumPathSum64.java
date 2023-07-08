package daily_problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumPathSum64 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int myMinPathSum(int[][] grid) {
            /* transition equation. coordination i,j = min(grid[i-1][j], grid[i][j-1])
             * [0][0] -> [1][0]
             * or -> [0][1]
             * A problem arises when rely on min values of two source positions, which is just partial optimized.
             * search?
             * I think it's silly.
             */
            int length = grid[0].length;
            int width = grid.length;
            int[][] directions = {{1, 0}, {0, 1}};
            int result = 0;
            Queue<State> queue = new PriorityQueue<>();
            HashSet<String> visited = new HashSet<>();
            State initial = new State(new int[]{0, 0}, grid[0][0]);
            queue.add(initial);
            result += initial.cost;
//            while (!queue.isEmpty()) {
//                State current = queue.poll();
//                if (current.coordination[0] == width - 1 && current.coordination[1] == length - 1) {
//                    result++;
//                    continue;
//                }
//                for (int[] direction : directions) {
//                    int[] newPosition = {currentPosition[0] + direction[0], currentPosition[1] + direction[1]};
//                    String stringPosition = Integer.toString(newPosition[0]) + Integer.toString(newPosition[1]);
//                    if (newPosition[0] < m && newPosition[0] >= 0 && newPosition[1] < n && newPosition[1] >= 0){
//                        queue.add(newPosition);
//                    }
//                }
//            }
            return result;
        }
        class State implements Comparable<State>{
            public int[] coordination;
            public int cost;
            public String key;

            public State(int[] coordination, int cost) {
                this.coordination = coordination;
                this.cost = cost;
                this.key = Integer.toString(coordination[0]) + Integer.toString(coordination[1]);
            }

            @Override
            public int compareTo(State o) {
                if (this.cost >= o.cost) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }

        public int minPathSum(int[][] grid) {
            int[][] minCost = new int[grid.length][grid[0].length];
            minCost[grid.length-1][grid[0].length-1] = grid[grid.length-1][grid[0].length];
            for (int i = minCost.length - 1; i >= 0 ; i--) {
                for (int j = minCost[0].length - 1; j >= 0; j--) {
                    if (i == minCost.length - 1 && j == minCost[0].length - 1) {
                        continue;
                    }
                    //if the cell is on bottom line
                    if (i == minCost.length - 1 && j != minCost[0].length - 1) {
                        minCost[i][j] = grid[i][j] + minCost[i][j + 1];
                    }
                    //if the cell is on rightmost column
                    else if (i != minCost.length - 1 && j == minCost[0].length - 1) {
                        minCost[i][j] = grid[i][j] + minCost[i + 1][j];
                    }
                    //if the cell is in inner area
                    else {
                        minCost[i][j] = grid[i][j] + Math.min(minCost[i + 1][j], minCost[i][j + 1]);
                    }
                }
            }
            return minCost[0][0];
        }
    }
}
