public class ServiceQueue {

    private static class Node {
        Student data;
        Node next;

        Node(Student data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public ServiceQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(Student student) {
        Node newNode = new Node(student);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("Enqueued: " + student.getName());
    }

    public Student dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! No students waiting.");
            return null;
        }
        Student removedStudent = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        System.out.println("Served (Dequeued): " + removedStudent.getName());
        return removedStudent;
    }

    public Student peek() {
        if (isEmpty()) {
            return null;
        }
        return front.data;
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("The queue is currently empty.");
            return;
        }
        System.out.println("\n--- Current Service Queue (Front -> Rear) ---");
        Node current = front;
        int position = 1;
        while (current != null) {
            System.out.printf("%2d. %s%n", position++, current.data);
            current = current.next;
        }
        System.out.println("Total waiting: " + size + "\n");
    }
}
