public class A3_Stack {

    private double[] data;
    private int top;
    private int capacity;

    public A3_Stack(int capacity) {
        this.capacity = capacity;
        this.data = new double[capacity];
        this.top = -1;
    }

    public A3_Stack() {
        this(50);
    }

    public void push(double value) {
        if (top == capacity - 1) {
            System.out.println("Stack overflow");
            return;
        }
        data[++top] = value;
    }

    public double pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow");
            return Double.NaN;
        }
        return data[top--];
    }

    public double peek() {
        if (isEmpty()) {
            return Double.NaN;
        }
        return data[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack: [ empty ]");
            return;
        }
        System.out.print("Stack (bottom -> top): [ ");
        for (int i = 0; i <= top; i++) {
            System.out.print(data[i]);
            if (i < top) System.out.print(", ");
        }
        System.out.println(" ]");
    }
}