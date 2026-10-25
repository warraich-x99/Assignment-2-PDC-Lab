public class RequestQueue {
    private char[] queueArray;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public RequestQueue(int capacity) {
        this.capacity = capacity;
        this.queueArray = new char[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(char c) {
        if (size >= capacity) {
            throw new IllegalStateException("RequestQueue overflow");
        }
        rear = (rear + 1) % capacity;
        queueArray[rear] = c;
        size++;
    }

    public char dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("RequestQueue underflow");
        }
        char c = queueArray[front];
        front = (front + 1) % capacity;
        size--;
        return c;
    }

    public boolean isEmpty() {
        return (size == 0);
    }
}// JavaDoc update
