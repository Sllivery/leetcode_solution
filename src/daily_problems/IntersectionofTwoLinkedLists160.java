package daily_problems;

import utils.ListNode;

import java.util.HashMap;
import java.util.HashSet;

public class IntersectionofTwoLinkedLists160 {
    public static void main(String[] args) {

    }
    static public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            HashMap<ListNode, ListNode> map = new HashMap<>();
            while (headA != null && headB != null) {
                if (map.containsKey(headA)) {
                    return map.get(headA);
                } else if (map.containsKey(headB)) {
                    return map.get(headB);
                } else if (headA == headB) {
                    return headA;
                } else {
                    map.put(headA, headA);
                    map.put(headB, headB);
                }
                headA = headA.next;
                headB = headB.next;
            }
            ListNode rest = headA != null ? headA : headB;
            while (rest != null) {
                if (map.containsKey(rest)) {
                    return map.get(rest);
                }
                else {
                    map.put(rest, rest);
                }
                rest = rest.next;
            }
            return null;
        }
    }
}
