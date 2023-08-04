package daily_problems;

import utils.TreeNode;

public class FlattenBinaryTreetoLinkedList114 {
    public static void main(String[] args) {

    }

    static class Solution {
        public void flatten(TreeNode root) {
            if (root == null) { //leaf
                return;
            }
            //store right subtree
            TreeNode rightBackup = root.right;
            //change left to right
            root.right = root.left;
            root.left = null;
            flatten(root.right);
            //connect the stored
            while (root.right != null) {
                root = root.right;
            }
            root.right = rightBackup;
            //flatten the sorted right tree
            flatten(root.right);
        }
    }
}
