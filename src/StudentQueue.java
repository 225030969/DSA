public class StudentQueue {
    private static class QueueNode {
        Student data;
        QueueNode next;

        QueueNode(Student data) {
            this.data = data;
            this.next = null;
        }
    }

    private QueueNode front;
    private QueueNode rear;
    private int size;

    public StudentQueue() {
        front = null;
        rear  = null;
        size  = 0;
    }

    public void enqueue(Student student) {
        if (student == null) {
            System.out.println("Cannot enqueue a null student.");
            return;
        }
        QueueNode newNode = new QueueNode(student);

        if (isEmpty()) {
            front = newNode;
            rear  = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("  [ENQUEUE] " + student.getName()
                + " joined the waiting line (position " + size + ").");
    }

    public Student dequeue() {
        if (isEmpty()) {
            System.out.println("  [DEQUEUE] Queue is empty - nobody to serve.");
            return null;
        }
        Student served = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }
        size--;
        System.out.println("  [DEQUEUE] Now serving: " + served.getName()
                + " (" + served.getServiceType() + ", "
                + served.getServiceTime() + " min).");
        return served;
    }

    public Student peek() {
        if (isEmpty()) {
            return null;
        }
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }

    public void displayQueue() {
        System.out.println("\n--- WAITING QUEUE (front -> rear) ---");
        if (isEmpty()) {
            System.out.println("  The waiting line is empty.");
            System.out.println("-------------------------------------");
            return;
        }
        System.out.println("Pos | " + Student.header());
        System.out.println("-------------------------------------------------------------");

        QueueNode current = front;
        int position = 1;
        while (current != null) {
            System.out.printf("%3d | %s%n", position, current.data);
            current = current.next;
            position++;
        }
        System.out.println("-------------------------------------------------------------");
        System.out.println("Students waiting: " + size
                + " | Next to be served: " + peek().getName());
    }
}