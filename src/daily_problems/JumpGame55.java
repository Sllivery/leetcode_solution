package daily_problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class JumpGame55 {
    public static void main(String[] args) {
        int[] test = {2,3,1,1,4};
        Solution solution = new Solution();
        boolean b = solution.canJump(test);
        System.out.println(b);
    }
    static class Solution {
        public boolean myCanJump(int[] nums) {
            //greedy doesn't gaurantee global solution. If we have a solution which can't take the maximum step
            int index = 0;
            while (index < nums.length) {
                int step = nums[index];
                if (step == 0 || index == nums.length - 1) {
                    break;
                }
                while (index + step > nums.length - 1) {
                    step--;
                }
                index += step;
            }
            if (index == nums.length - 1) {
                return true;
            } else if (nums[index] == 0 && index < nums.length - 1) {
                return false;
            } else {
                return false;
            }
        }

        public boolean canJumpSearch(int[] nums) {
            //这样做确实可以，但是效率太低了。搜索算法的本质还是穷举。
            //果然，超时了
            //那么，有什么可以优化的吗？A*搜索可以
            Queue<Node> queue = new LinkedList<>();
            HashSet<String> set = new HashSet<>();
            queue.add(new Node(0, nums[0]));
            while (!queue.isEmpty()) {
                Node item = queue.poll();
                if (item.index == nums.length - 1) {
                    return true;
                }
                for (int i = item.step; i >= 1; i--) {
                    if (item.index + i < nums.length) {
                        int newIndex = item.index + i;
                        int newStep = nums[newIndex];
                        Node newNode = new Node(newIndex, newStep);
                        String key = newIndex + " " + newStep;
                        if (!set.contains(key)) {
                            set.add(key);
                            queue.add(newNode);
                        }
                    }
                }
            }
            return false;
        }

        public boolean canJump(int[] nums) {
            //这样的题目有个典型的特点：当贪心不成时还有其他选择，这样的题一般想到回溯
            //回溯和DP也有关系
            //让我思考的是，这题用复杂的算法能解出来，但是如何提炼出以下这种精炼的逻辑？
            int leftMostGoodIndex = nums.length - 1;
            for (int i = nums.length - 2; i >= 0 ; i--) {
                if (i + nums[i] >= leftMostGoodIndex) {
                    leftMostGoodIndex = i;
                }
            }
            return leftMostGoodIndex == 0;
        }
        class Node{
            public int index;
            public int step;

            public Node(int index, int step) {
                this.index = index;
                this.step = step;
            }
        }
    }
}
