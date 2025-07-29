class MyCircularDeque {
    static int arr[];
    static int front;
    static int rear;
    static int size;
    final int capacity;

    public MyCircularDeque(int k) {
        arr = new int[k];
        capacity = k;
        front = -1;
        rear = 0;
        size = 0;
    }
    
    public boolean insertFront(int value) {
         if (isFull()) {
            return false;
        }
        
        if (isEmpty()) {
            front = rear = 0;
        } else {
            front = (front - 1 + capacity) % capacity;
        }
        
        arr[front] = value;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        
        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }
        
        arr[rear] = value;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        
        if (front == rear) {
            // Only one element in deque
            front = -1;
            rear = 0;
        } else {
            front = (front + 1) % capacity;
        }
        
        size--;
        return true;
    }
    
    public boolean deleteLast() {
         if (isEmpty()) {
            return false;
        }
        
        if (front == rear) {
            // Only one element in deque
            front = -1;
            rear = 0;
        } else {
            rear = (rear - 1 + capacity) % capacity;
        }
        
        size--;
        return true;
    }
    
    public int getFront() {
        return isEmpty() ? -1 : arr[front];
    }
    
    public int getRear() {
        return isEmpty() ? -1 : arr[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
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