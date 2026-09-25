public class CustomQueue {
    private Node front;
    private Node rear;
    private int size;

    private static class Node {
        Student data;
        Node next;

        Node(Student data) {
            this.data = data;
            this.next = null;
        }
    }

    public CustomQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void enqueue(Student student) {
        Node newNode = new Node(student);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("[ENQUEUE] Added student to queue: " + student.getName());
    }

    public Student dequeue() {
        if (isEmpty()) {
            System.out.println("[DEQUEUE ERROR] Queue is empty!");
            return null;
        }
        Student dequeuedStudent = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return dequeuedStudent;
    }

    public Student peek() {
        return isEmpty() ? null : front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("\n--- WAITING QUEUE IS EMPTY ---");
            return;
        }
        System.out.println("\n--- CURRENT WAITING QUEUE (Front to Rear) ---");
        Node current = front;
        int pos = 1;
        while (current != null) {
            System.out.println(" Position " + (pos++) + ": " + current.data);
            current = current.next;
        }
    }
