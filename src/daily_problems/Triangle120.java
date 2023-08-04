package daily_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Triangle120 {
    public static void main(String[] args) {

    }

     static class Solution{
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
                if (lastSum < min[0]){
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
