package daily_problems;

import java.util.ArrayList;
import java.util.List;

public class Permutations46 {

    public static void main(String[] args) {
        int[] test = {0,1};
        Solution solution = new Solution();
        List<List<Integer>> per = solution.permute(test);
        for (List<Integer> integers : per) {
            for (Integer integer : integers) {
                System.out.print(integer);
            }
            System.out.println("");
        }
    }

    static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            ArrayList<List<Integer>> result = new ArrayList<>();
            backtract(result, new ArrayList<>(), 0, nums);
            return result;
        }

        private void backtract(ArrayList<List<Integer>> result, ArrayList<Integer> temp, int index, int[] nums){
            if (temp.size() == nums.length) {
                result.add(new ArrayList<>(temp));
                return;
            }
            for (int i = index; i < nums.length; i++) {
                if (!temp.contains(nums[i])) {
                    temp.add(nums[i]);
                } else {
                    continue;
                }
                backtract(result, temp, index, nums);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
