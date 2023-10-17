package daily_problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LRUCache146 {
    public static void main(String[] args) {

    }

    class LRUCache {
        HashMap<Integer, ListNode> map;
        int capacity;
        ListNode head;
        ListNode tail;
        public LRUCache(int capacity) {
            this.map = new HashMap<>();
            this.head = new ListNode(-1, -1);
            this.tail = new ListNode(-1, -1);
            this.head.next = tail;
            this.tail.prev = head;
            this.capacity = capacity;
        }

        //get and cache.
        public int get(int key) {
            //check if exist
            if (!map.containsKey(key)) {
                return -1;
            }
            //update priority
            ListNode node = map.get(key);
            remove(key);
            add(node);
            return node.value;
        }

        public void put(int key, int value) {
            //if key exist, update
            if (map.containsKey(key)) {
                ListNode node = map.get(key);
                remove(node.key);
            }
            //if not exist
            ListNode node = new ListNode(key, value);
            map.put(key, node);
            add(node);
            //if full
            if (map.size() > capacity) {
                ListNode removeNode = this.head.next;
                remove(removeNode.key);
                map.remove(removeNode.key);
            }
        }

        private void remove(int key) {
            ListNode node = this.map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void add(ListNode node) {
            ListNode prevEnd = this.tail.prev;
            prevEnd.next = node;
            node.prev = prevEnd;
            node.next = this.tail;
            this.tail.prev = node;
        }
        class ListNode {
            int key;
            int value;
            ListNode prev;
            ListNode next;

            public ListNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }
}
