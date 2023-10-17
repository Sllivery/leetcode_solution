package extra.homework_solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DistinctPairs {
    public static void main(String[] args) {
        int[] nums = {1, 19, 5, 19}; //(0, 1), (0, 2), (0, 3), (2, 3), (5, 19)
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            solution(nums, i, i + 1, result);
        }
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static void solution(int[] nums, int source, int target, List<int[]> result){
        if (target == nums.length){
            return;
        }
        if (nums[source] != nums[target]){
            result.add(new int[]{source, target});
        }
        for (int i = source + 2; i < nums.length; i++) {
            solution(nums, source, i, result);
        }
    }
}
