public class A2_LinkedList {

    private class Node {
        Student data;
        Node next;

        Node(Student data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public A2_LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void insertAtBeginning(Student student) {
        Node newNode = new Node(student);
        newNode.next = head;
        head = newNode;
        size++;
        System.out.println("Inserted at beginning: " + student.getName());
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
        System.out.println("Inserted at end: " + student.getName());
    }

    public void insertAtPosition(Student student, int position) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            insertAtBeginning(student);
            return;
        }

        Node newNode = new Node(student);
        Node current = head;
        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
        System.out.println("Inserted at position " + position + ": " + student.getName());
    }

    public void insertStudent(Student student) {
        insertAtEnd(student);
    }

    public boolean deleteStudent(String studentNo) {
        if (head == null) {
            System.out.println("List is empty.");
            return false;
        }

        if (head.data.getStudentNo().equals(studentNo)) {
            System.out.println("Deleted: " + head.data.getName());
            head = head.next;
            size--;
            return true;
        }

        Node current = head;
        while (current.next != null && !current.next.data.getStudentNo().equals(studentNo)) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Student not found.");
            return false;
        }

        System.out.println("Deleted: " + current.next.data.getName());
        current.next = current.next.next;
        size--;
        return true;
    }

    public Student searchStudent(String studentNo) {
        Node current = head;
        int position = 1;
        while (current != null) {
            if (current.data.getStudentNo().equals(studentNo)) {
                System.out.println("Found at position " + position + ": " + current.data);
                return current.data;
            }
            current = current.next;
            position++;
        }
        System.out.println("Student not found.");
        return null;
    }

    public void displayStudents() {
        if (head == null) {
            System.out.println("No student service records.");
            return;
        }

        System.out.println("\n===== STUDENT SERVICE RECORDS =====");
        System.out.println("Pos | Student");
        System.out.println("----------------------");

        Node current = head;
        int pos = 1;
        while (current != null) {
            System.out.println(pos + "   | " + current.data);
            current = current.next;
            pos++;
        }
        System.out.println("Total records: " + size);
        System.out.println("===================================\n");
    }
}