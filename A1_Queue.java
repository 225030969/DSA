public class A1_Queue {

    private Student[] data;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public A1_Queue(int capacity) {
        this.capacity = capacity;
        this.data = new Student[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public A1_Queue() {
        this(50);
    }

    public void enqueue(Student student) {
        if (size == capacity) {
            System.out.println("Queue is full. Cannot add more students.");
            return;
        }
        rear = (rear + 1) % capacity;
        data[rear] = student;
        size++;
        System.out.println("Enqueued: " + student.getName());
    }

    public Student dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No student to serve.");
            return null;
        }
        Student served = data[front];
        data[front] = null;
        front = (front + 1) % capacity;
        size--;
        System.out.println("Served: " + served.getName());
        return served;
    }

    public Student peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }
        return data[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Waiting queue is empty.");
            return;
        }

        System.out.println("\n===== WAITING QUEUE =====");
        System.out.println("Pos | Student");
        System.out.println("----------------------");

        int index = front;
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + "   | " + data[index]);
            index = (index + 1) % capacity;
        }
        System.out.println("========================\n");
    }
}