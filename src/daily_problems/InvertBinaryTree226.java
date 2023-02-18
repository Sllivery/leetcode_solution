package daily_problems;

import com.sun.source.tree.Tree;
import microsoft_q.trees_graph.BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InvertBinaryTree226 {
    public static void main(String[] args) {

    }

    static class Solution {
        /*
        这个问题的关键在于发现适用递归的条件：
        子问题 = 总问题的分解
         */
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return null;
            helper(root);
            return root;
        }

        public void helper(TreeNode root) {
            if (root == null) {
                return;
            }
            helper(root.left);
            helper(root.right);
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
