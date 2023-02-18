package microsoft_q.trees_graph;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {

    }

    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            List<List<Integer>> list = new ArrayList<>();
            if (root == null) return list;
            q.add(root);
            int level = 0;
            while (q.size() > 0) {
                list.add(new ArrayList<>());
                int currentLevelCount = q.size();
                for (int i = 1; i <= currentLevelCount; i++) {
                    TreeNode current = q.poll();
                    list.get(level).add(current.val);
                    if (current.left != null) q.add(current.left);
                    if (current.right != null) q.add(current.right);
                }
                level++;
            }
            return list;
        }
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
