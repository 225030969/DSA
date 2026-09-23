public class CustomLinkedList {
    private Node head;
    private int size;

    private static class Node {
        Student data;
        Node next;

        Node(Student data) {
            this.data = data;
            this.next = null;
        }
    }

    public CustomLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void insertAtEnd(Student student) {
        Node newNode = new Node(student);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        System.out.println("[RECORD INSERTED] " + student.getName());
    }

    public void insertAtPosition(Student student, int position) {
        if (position < 1 || position > size + 1) {
            System.out.println("[ERROR] Invalid position range.");
            return;
        }
        Node newNode = new Node(student);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 1; i < position - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
        System.out.println("[RECORD INSERTED AT POS " + position + "] " + student.getName());
    }

    public boolean deleteStudent(String studentNo) {
        if (head == null) return false;
        if (head.data.getStudentNo().equalsIgnoreCase(studentNo)) {
            head = head.next;
            size--;
            return true;
        }

        Node current = head;
        while (current.next != null && !current.next.data.getStudentNo().equalsIgnoreCase(studentNo)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            size--;
            return true;
        }
        return false;
    }

    public Student searchStudent(String studentNo) {
        Node current = head;
        while (current != null) {
            if (current.data.getStudentNo().equalsIgnoreCase(studentNo)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    public void displayStudents() {
        if (head == null) {
            System.out.println("\n--- NO STUDENT SERVICE RECORDS FOUND ---");
            return;
        }
        System.out.println("\n--- STUDENT SERVICE RECORDS (LINKED LIST) ---");
        Node current = head;
        while (current != null) {
            System.out.println(" " + current.data);
            current = current.next;
        }
    }

    public int getSize() { return size; }
}