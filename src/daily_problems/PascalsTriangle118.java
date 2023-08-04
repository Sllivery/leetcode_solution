package daily_problems;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class PascalsTriangle118 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> generate = solution.generate(5);
        for (List<Integer> list : generate) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    static class Solution{
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> first = new ArrayList<>();
            first.add(1);
            List<Integer> second = new ArrayList<>();
            second.add(1);
            second.add(1);
            result.add(first);
            if (numRows == 1) {
                return result;
            }
            result.add(second);
            if (numRows == 2) {
                return result;
            }
            helper(numRows, result);
            return result;
        }

        public List<Integer> helper(int num, List<List<Integer>> result) {
            if (num == 3) {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                List<Integer> pre = result.get(1);
                int slow = 0;
                int fast = 1;
                int newInteger = pre.get(slow) + pre.get(fast);
                list.add(newInteger);
                list.add(1);
                result.add(list);
                return list;
            }
            List<Integer> last = helper(num - 1, result);
            List<Integer> list = new ArrayList<>();
            list.add(1);
            int slow = 0;
            int fast = 1;
            while (fast < last.size()) {
                int newInteger = last.get(slow) + last.get(fast);
                list.add(newInteger);
                slow++;
                fast++;
            }
            list.add(1);
            result.add(list);
            return list;
        }
    }
}
