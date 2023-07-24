package daily_problems;

import com.sun.source.tree.Tree;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal103 {
    public static void main(String[] args) {

    }

    static class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<List<Integer>>();
            }
            List<List<Integer>> result = new ArrayList<>();
            LinkedList<Integer> levelList = new LinkedList<>();
            LinkedList<TreeNode> linkedList = new LinkedList<>();
            linkedList.addFirst(root);
            linkedList.add(null);
            boolean isLeftToRight = true;
            while (!linkedList.isEmpty()) {
                TreeNode curr = linkedList.pollFirst();
                if (curr == null) {
                    result.add(levelList);
                    levelList = new LinkedList<>();
                    if (!linkedList.isEmpty()) {
                        linkedList.addLast(null);
                    }
                    isLeftToRight = !isLeftToRight;
                    continue;
                }
                if (isLeftToRight) {
                    levelList.addLast(curr.val);
                }
                if (!isLeftToRight) {
                    levelList.addFirst(curr.val);
                }
                if (curr.left != null) linkedList.addFirst(curr.left);
                if (curr.right != null) linkedList.addFirst(curr.right);
            }
            return result;
        }
    }
}
