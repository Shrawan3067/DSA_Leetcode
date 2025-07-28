class MyCircularQueue {
    public static int arr[];
    public static int size;
    public static int front;
    public static int rear;

    public MyCircularQueue(int k) {
        size = k;
        rear = -1;
        front = -1;
        arr = new int[k];
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (front == -1) {
            front = 0;
        }
        rear = (rear + 1) % size;
        arr[rear] = value;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (rear == front) {
            rear = front = -1;
        } else {
            front = (front + 1) % size;
        }
        return true;
    }
    
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }
    
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[rear];
    }
    
    public boolean isEmpty() {
        return rear == -1 && front == -1;
    }
    
    public boolean isFull() {
        return (rear + 1) % size == front;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */