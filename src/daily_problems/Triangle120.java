package daily_problems;

import java.util.*;

public class Triangle120 {
    public static void main(String[] args) {

    }

    static class Solution2{
        public int minimumTotal(List<List<Integer>> triangle) {
            for (int i = 1; i < triangle.size(); i++) {
                for (int j = 0; j < triangle.get(i).size(); j++) {
                    int minAbove = Integer.MAX_VALUE;
                    //there're three possible cases: 1. current cell is on the left most 2.current cell is in the middle range 3.on the right most
                    //1.minAbove is just cell abvoe and same reason for case 3  2.minAbove is the min between cell(y-1, x) and cell(y-1, x-1)
                    if (j > 0) {
                        minAbove = triangle.get(i - 1).get(j - 1);
                    }
                    if (j < i) {
                        minAbove = Math.min(minAbove, triangle.get(i - 1).get(j));
                    }
                    int currentMin = minAbove + triangle.get(i).get(j);
                    //update
                    triangle.get(i).set(j, currentMin);
                }
            }
            return Collections.min(triangle.get(triangle.size() - 1));
        }
    }

    static class Solution1 {
        //很经典的错误，这种代码结构也没法用memo
        public int minimumTotal(List<List<Integer>> triangle) {
            int[] min = {Integer.MAX_VALUE};
            int currentNum = triangle.get(0).get(0);
            int currentSum = triangle.get(0).get(0);
            helper(0, 1, currentNum, triangle, currentSum, min);
            helper(1, 1, currentNum, triangle, currentSum, min);
            return min[0];
        }

        public void helper(int innerIndex, int outterIndex, int lastNum, List<List<Integer>> triangle, int lastSum, int[] min) {
            if (outterIndex == triangle.size()) {
                if (lastSum < min[0]) {
                    min[0] = lastSum;
                }
                return;
            }

            int currentNum = triangle.get(outterIndex).get(innerIndex);
            int currentSum = lastSum + currentNum;

            helper(innerIndex, outterIndex + 1, currentNum, triangle, currentSum, min);
            helper(innerIndex + 1, outterIndex + 1, currentNum, triangle, currentSum, min);
        }
    }
}
