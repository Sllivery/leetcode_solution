package extra.basic;

import utils.TreeNode;

public class AVLTree<T> {
    private class AVLTreeNode<T> extends TreeNode<T> {
        private int balanceFactor;

        public AVLTreeNode(T val) {
            super(val);
        }

        public int getBalanceFactor() {
            return balanceFactor;
        }

        public void setBalanceFactor(int balanceFactor) {
            this.balanceFactor = balanceFactor;
        }
    }

    public boolean insert(T val) {
        return false;
    }

    public boolean delete(T val) {
        return false;
    }

    private boolean rotate() {
        return false;
    }
}
