package daily_problems;

import com.sun.source.tree.Tree;
import utils.TreeNode;

import java.util.HashMap;

public class ConstructBinaryTreefromPreorderandInorderTraversal105 {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        Solution solution = new Solution();
        solution.buildTree(preorder, inorder);
    }

    static class Solution {
        int rootIndex = 0;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int index = 0;
            HashMap<Integer, Integer> inorderMap = new HashMap<>();
            for (int i : inorder) {
                inorderMap.put(i, index);
                index++;
            }
            return helper(preorder, rootIndex, preorder.length - 1, inorderMap);
        }

        public TreeNode helper(int[] preorder, int leftIndex, int rightIndex, HashMap<Integer, Integer> map) {
            if (leftIndex > rightIndex) {//isLeaf
                return null;
            }
            int currentValue = preorder[rootIndex++];
            TreeNode currentRoot = new TreeNode(currentValue);
            currentRoot.left = helper(preorder, leftIndex, map.get(currentValue) - 1, map);
            currentRoot.right = helper(preorder,map.get(currentValue) + 1, rightIndex, map);
            return currentRoot;
        }
    }
}
