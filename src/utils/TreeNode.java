package utils;

public class TreeNode<T extends TreeNode> {
    public int val;

    public T left;
    public T right;

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, T left, T right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
