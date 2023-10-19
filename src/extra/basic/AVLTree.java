package extra.basic;

import utils.TreeNode;

public class AVLTree {
    private AVLTreeNode root;

    public AVLTree(int val) {
        this.root = new AVLTreeNode(val);
    }

    public void insert(int val) {
        AVLTreeNode node = insertNode(val, this.root);
        updateHeight(node);
        reBalance(this.root);
    }

    private AVLTreeNode insertNode(int val, AVLTreeNode node){
        if (node == null) {
            return new AVLTreeNode(val);
        } else if (val > node.val) { //left is greater than it's parent
            node.left = insertNode(val, node.left);
        } else if (val < node.val) { //right is less than it's parent
            node.right = insertNode(val, node.right);
        }
        return node;
    }

    private void updateHeight(AVLTreeNode node){
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        node.height = Math.max(leftHeight, rightHeight) + 1;
    }

    private int height(AVLTreeNode node){
        if (node == null){
            return -1;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public void delete(int val) {
        AVLTreeNode node = deleteNode(val, this.root);
        updateHeight(node);
        reBalance(node);
    }

    private AVLTreeNode deleteNode(int val, AVLTreeNode node) {
        // No node at current position --> go up the recursion
        if (node == null) {
            return null;
        }

        // Traverse the tree to the left or right depending on the key
        if (val < node.val) {
            node.left = deleteNode(val, node.left);
        } else if (val > node.val) {
            node.right = deleteNode(val, node.right);
        }

        // Node has no children --> just delete it
        else if (node.left == null && node.right == null) {
            node = null;
        }

        // Node has only one child --> replace node by its single child
        else if (node.left == null) {
            node = node.right;
        } else if (node.right == null) {
            node = node.left;
        }

        // Node has two children
        else {
            deleteNodeWithTwoChildren(node);
        }

        return node;
    }

    private AVLTreeNode rotateRight(AVLTreeNode node) {
        //draw a pic will help understanding
        AVLTreeNode nodeLeft = node.left;
        node.left = nodeLeft.right;
        nodeLeft.right = node;
        //the nodes whose child chaged need to update its height
        updateHeight(node);
        updateHeight(nodeLeft);
        return nodeLeft;
    }

    private AVLTreeNode rotateLeft(AVLTreeNode node) {
        AVLTreeNode nodeRight = node.right;
        node.left = nodeRight.left;
        nodeRight.right = node;
        updateHeight(nodeRight);
        updateHeight(node);
        return nodeRight;
    }

    private AVLTreeNode reBalance(AVLTreeNode node){
        int balanceFactor = balanceFactor(node);

        // Left-heavy?
        if (balanceFactor < -1) {
            if (balanceFactor(node.left) <= 0) {    // Case 1
                // Rotate right
                node = rotateRight(node);
            } else {                                // Case 2
                // Rotate left-right
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        }

        // Right-heavy?
        if (balanceFactor > 1) {
            if (balanceFactor(node.right) >= 0) {    // Case 3
                // Rotate left
                node = rotateLeft(node);
            } else {                                 // Case 4
                // Rotate right-left
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        }

        return node;
    }

    private void deleteNodeWithTwoChildren(AVLTreeNode node) {
        // Find minimum node of right subtree ("inorder successor" of current node)
        AVLTreeNode inOrderSuccessor = findMinimum(node.right);

        // Copy inorder successor's data to current node
        node.val = inOrderSuccessor.val;

        // Delete inorder successor recursively
        node.right = deleteNode(inOrderSuccessor.val, node.right);
    }

    private AVLTreeNode findMinimum(AVLTreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private int balanceFactor(AVLTreeNode node) {
        return height(node.right) - height(node.left);
    }

    private class AVLTreeNode extends TreeNode<AVLTreeNode> {
        private int balanceFactor;
        private int height;


        public AVLTreeNode(int val) {
            super(val);
        }

        public int getBalanceFactor() {
            return balanceFactor;
        }

        public void setBalanceFactor(int balanceFactor) {
            this.balanceFactor = balanceFactor;
        }
    }
}
