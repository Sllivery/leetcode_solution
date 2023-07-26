package daily_problems;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeLevelOrderTraversalII107 {
    public static void main(String[] args) {

    }

    static class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if (root == null) {
                return new ArrayList<List<Integer>>();
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            LinkedList<Integer> level = new LinkedList<>();
            LinkedList<List<Integer>> result = new LinkedList<>();
            queue.add(root);
            queue.add(null);
            while (!queue.isEmpty()) {
                TreeNode last = queue.pop();
                if (last != null) { //use null to mark a level
                    level.add(last.val);
                    if (last.left != null) {
                        queue.add(last.left);
                    }
                    if (last.right != null) {
                        queue.add(last.right);
                    }
                } else {
                    //end of a one level
                    result.addFirst(new ArrayList<>(level));
                    if (!queue.isEmpty()) {
                        queue.add(null);
                    }
                    level.clear();
                }
            }
            return result;
        }
    }
}
