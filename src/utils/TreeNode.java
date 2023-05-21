package utils;

public class TreeNode<T> {
    private T val;
    private int height;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public TreeNode(T val) {
        this.val = val;
    }


}
