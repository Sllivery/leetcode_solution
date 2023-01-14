package extra.data_structure;

import java.util.Arrays;

public class Heap {
    private int capacity = 10;
    private int size = 0;

    private int items[] = new int[capacity];

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private int hasLeftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private int hasRightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private int hasParent(int index) {
        return items[getParentIndex(index)];
    }

    private void swap(int index1, int index2) {
        int temp = index1;
        index1 = index2;
        index2 = temp;
    }

    private void ensureCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    public void add(int item) {
        ensureCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    public int peek() {
        //attention remember to check the size
        if (size == 0) throw new IllegalStateException();
        return items[0];
    }

    public int poll() {
        //attention remember to check the size
        if (size == 0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;
    }

    private void heapifyUp() {
    }

    private void heapifyDown() {
    }
}


