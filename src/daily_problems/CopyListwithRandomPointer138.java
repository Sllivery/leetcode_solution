package daily_problems;

import utils.ListNode;
import utils.Node;

import java.util.HashMap;

public class CopyListwithRandomPointer138 {

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        ListNode head = new ListNode(array);

        ListNode head2 = copyOfList(head);
        System.out.println(head);
        System.out.println(head2);
    }

    private static ListNode copyOfList(ListNode originalHead) {
        if (originalHead == null) {
            return null;
        }
        ListNode newCurr = new ListNode(originalHead.val);
        newCurr.next = copyOfList(originalHead.next);
        return newCurr;
    }

    static class Solution {
        public Node copyRandomList(Node head) {
            HashMap<Node, Node> visited = new HashMap<>();
            return copyofSimpleList(head, visited);
        }

        private Node copyofSimpleList(Node head, HashMap<Node, Node> visited) {
            if (head == null) {
                return null;
            }
            if (visited.containsKey(head)) {
                return visited.get(head);
            }
            //newCurrent created by node, so do random.
            Node newCurrent = new Node(head.val);
            visited.put(head, newCurrent);
            //but it would cause dead loop, need to record the nodes that have visited. return the visted node and make it as next
            newCurrent.next = copyofSimpleList(head.next, visited);
            newCurrent.random = copyofSimpleList(head.random, visited);
            return newCurrent;
        }
    }
}
