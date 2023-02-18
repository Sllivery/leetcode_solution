package microsoft_q.trees_graph;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {

    }

    static class Solution{
        public boolean isValidBST(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            preOrder(root, list);
            return judgeOrder(list);
        }

        private void preOrder(TreeNode root, List<Integer> list){
            if (root == null) return;
            preOrder(root.left, list);
            list.add(root.val);
            preOrder(root.right, list);
        }

        private boolean judgeOrder(List<Integer> list){
            int preIndex = 0;
            int postIndex = preIndex + 1;
            for (;preIndex <= list.size() - 2;preIndex ++, postIndex ++){
                if(list.get(postIndex) <= list.get(preIndex)) return false;
            }
            return true;
        }
    }


    static class TreeNode {
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
