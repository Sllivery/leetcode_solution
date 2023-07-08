package daily_problems;

import utils.ListNode;

public class RotateList61 {
    public static void main(String[] args) {
        //突然有个疑问是：新声明一个pointer指向head。head变了，pointer会不会变。
        //更一般情况的问题是：java中，两个变量名同时指向一个引用类型，是不是都会变。
    }
    
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null) return null;
            if (head.next == null) return head;
            //connect the tail to the head
            ListNode tail = head;
            int count = 1;
            while (tail.next != null){
                count++;
                tail = tail.next;
            }
            tail.next = head;
            //break the connection at kth node
            ListNode breakPoint = head;
            for (int i = 0; i < count - k % count - 1; i++){
                breakPoint = breakPoint.next;
            }
            ListNode result = breakPoint.next;
            breakPoint.next = null;
            return result;
        }
    }
}
