package daily_problems;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SameTree100 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q != null || p != null && q == null) {
                return false;
            }
            //同时为空返回
            if (p == null && q == null) {
                return true;
            }
            boolean re = true;
            re = isSameTree(p.left, q.left);
            if (p.val != q.val) {
                return false;
            }
            if (!re) {
                return re;
            }
            re = isSameTree(p.right, q.right);
            return re;
        }
    }
}
