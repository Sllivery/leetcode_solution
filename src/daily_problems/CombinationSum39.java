package daily_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CombinationSum39 {
    public static void main(String[] args) {
        int[] array = {2,3,6,7};
        Solution solution = new Solution();
        List<List<Integer>> result = solution.combinationSum(array, 7);
        for (List<Integer> integers : result) {
            for (Integer integer : integers) {
                System.out.print(integer);
            }
            System.out.println("");
        }
    }

    static void conutPlus(int count) {
        count++;
    }

    static void test(ArrayList<Integer> list, int n){
        if (n > 8) {
            return;
        }
        list.add(1);
        test(list, n+1);
    }

    static class Solution{
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            ArrayList<List<Integer>> result = new ArrayList<>();
            Arrays.sort(candidates);
            backtract(result, new ArrayList<Integer>(), candidates, target, 0);
            return result;
        }

        private void backtract(ArrayList<List<Integer>> result, List<Integer> temp, int[] candidates, int remain, int index){ //purpose of this function is adding satisfied list to the result
            //boundary condition
            if (remain < 0) {
                return;
            } else if (remain == 0){
                result.add(new ArrayList<>(temp));
            } else {
                for (int i = index; i < candidates.length; i++) {
                    temp.add(candidates[i]); //add a new one and test it
                    //backtract(result, temp, candidates, remain - candidates[i], index);
                    backtract(result, temp, candidates, remain - candidates[i], i);
                    //传index和传i让我困扰了一小时。首先论证为什么i是对的
                    //比如第一个值是2-2-3，那么下一次2-3时，因为3的index是1，2的index是0，那么不可能2-3-2这样的情况，i不会变小。
                    //所以说为什么要让传进来的array是升序
                    temp.remove(temp.size() - 1); //when the code comes here, it means the number isn't fit the condition, we need to remove from the end
                }
            }

        }

        public List<List<Integer>> combinationSum2(int[] nums, int target) {
            List<List<Integer>> list = new ArrayList<>();
            Arrays.sort(nums);
            backtrack(list, new ArrayList<>(), nums, target, 0);
            return list;
        }

        private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
            if(remain < 0) return;
            else if(remain == 0) {
                list.add(new ArrayList<>(tempList));
                System.out.println(tempList.toString());
            }
            else{
                for(int i = start; i < nums.length; i++){
                    tempList.add(nums[i]);
                    backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                    tempList.remove(tempList.size() - 1);
                }
            }
        }

        public List<List<Integer>> mycombinationSum(int[] candidates, int target) {
            List<List<Integer>> resultList = new ArrayList<>();
            HashSet<int[]> visited = new HashSet<>();
            helper(target, resultList, new ArrayList<Integer>(), candidates, visited);
            return resultList;
        }

        private void helper(int target, List<List<Integer>> resultList, List<Integer> localList, int[] candidates, HashSet<int[]> visited) {
            //boundary condition
            if (target < 0) {
                return;
            }
            //trim branch factors
            Integer[] array = localList.toArray(new Integer[0]);
            Arrays.sort(array);
            if (visited.contains(array)) {
                return;
            }
            if (target == 0) {
                resultList.add(localList);
            }
            //regular operations
            for (int candidate : candidates) {
                helper(target - candidate, resultList, localList, candidates, visited);
            }
        }
    }
}
