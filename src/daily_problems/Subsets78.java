package daily_problems;

import java.util.ArrayList;
import java.util.List;

public class Subsets78 {
    public static void main(String[] args) {
        int[] test = {1,2,3};
        Solution solution = new Solution();
        List<List<Integer>> result = solution.subsets(test);
        for (List<Integer> integers : result) {
            for (Integer integer : integers) {
                System.out.print(integer);
            }
            System.out.println("");
        }
    }

    static class Solution{
        public List<List<Integer>> subsets(int[] nums) {
            ArrayList<List<Integer>> result = new ArrayList<>();
            backtract(result, nums, new ArrayList<>(), 0);
            return result;
        }

        private void backtract(ArrayList<List<Integer>> result, int[] nums, ArrayList<Integer> temp, int index){
            result.add(new ArrayList<>(temp));//add a null
            if (temp.size() == nums.length) {
                return;
            }
            for (int i = index; i < nums.length; i++) {
                temp.add(nums[i]);
                backtract(result, nums, temp, i+1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
