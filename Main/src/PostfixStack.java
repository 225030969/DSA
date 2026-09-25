class PostfixStack {
    private double[] stack;
    private int top;
    private int capacity;

    public PostfixStack(int capacity) {
        this.capacity = capacity;
        this.stack = new double[capacity];
        this.top = -1;
    }

    public void push(double value) {
        if (top < capacity - 1) {
            stack[++top] = value;
        }
    }

    public double pop() {
        if (!isEmpty()) {
            return stack[top--];
        }
        throw new IllegalStateException("Stack Underflow");
    }

    public double peek() {
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
