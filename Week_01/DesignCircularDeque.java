class MyCircularDeque {

    private int capacity;
    private int size = 0;
    private MyNode head = null;
    private MyNode tail = null;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        if (k < 0) throw new IllegalArgumentException();
        this.capacity = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (size + 1 > capacity) {
            return false;
        }

        MyNode newNode = new MyNode(value);
        linkByType(newNode, 0);
        size ++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (size + 1 > capacity) {
            return false;
        }

        MyNode newNode = new MyNode(value);
        linkByType(newNode, 1);
        size ++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (size == 0) return false;
        if (head == tail) {
            head = tail = null;
        } else {
            tail.next = head.next;
            head.next.pre = tail;
            head = head.next;
        }
        size--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (size == 0) return false;
        if (head == tail) {
            head = tail = null;
        } else {
            head.pre = tail.pre;
            tail.pre.next = head;
            tail = tail.pre;
        }
        
        size--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        return head == null ? -1 : head.value;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        return tail == null ? -1 : tail.value;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }

    /** type=0:linkHead else:linkTail */
    private void linkByType(MyNode newNode, int type) {
        if (size == 0) {
            this.head = this.tail = newNode;
            this.head.next = this.head.pre = this.tail.pre = this.tail.next = newNode;
            return;
        } 

        newNode.next = head;
        newNode.pre = tail;
        tail.next = newNode;
        head.pre = newNode;
        if (type == 0) {
            head = newNode;
        } else {
            tail = newNode;
        }
        
    }

    private static class MyNode {
        MyNode pre;
        MyNode next;
        int value;

        public MyNode(int value) {
            this.value = value;
        }
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
