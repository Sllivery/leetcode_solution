package microsoft_q.trees_graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {
    public static void main(String[] args) {

    }

    static class Solution{
        public Node connect(Node root) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int currentLevelNumber = queue.size();
                List<Node> innerList = new ArrayList<>();
                for (int i = 0; i < currentLevelNumber - 1 ; i++) {
                    Node current = queue.poll();
                    current.next = queue.peek();
                    if(current.left != null) queue.add(current.left);
                    if(current.right != null) queue.add(current.right);
                }
            }
            return root;
        }
    }

    static class Node{
        public int val;
        public Node left;
        public Node right;
        public Node next;
        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
