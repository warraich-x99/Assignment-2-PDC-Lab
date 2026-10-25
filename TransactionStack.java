public class TransactionStack {
private char[] stackArray;
    private int top;
    private int capacity;

    public TransactionStack(int capacity) {
        this.capacity = capacity;
        this.stackArray = new char[capacity];
        this.top = -1;
    }

    public void push(char c) {
        if (top >= capacity - 1) {
            throw new StackOverflowError("TransactionStack overflow");
        }
        stackArray[++top] = c;
    }

    public char pop() {
        if (isEmpty()) {
            throw new IllegalStateException("TransactionStack underflow");
        }
        return stackArray[top--];
    }

    public char peek() {
        if (isEmpty()) {
            throw new IllegalStateException("TransactionStack is empty");
        }
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}// JavaDoc update
