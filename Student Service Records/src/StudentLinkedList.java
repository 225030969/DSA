public class StudentLinkedList {

    // Student model class embedded directly
    public static class Student {
        private String studentNo;
        private String name;
        private String serviceType;
        private int estimatedServiceTime;

        public Student(String studentNo, String name, String serviceType, int estimatedServiceTime) {
            this.studentNo = studentNo;
            this.name = name;
            this.serviceType = serviceType;
            this.estimatedServiceTime = estimatedServiceTime;
        }

        public String getStudentNo() { return studentNo; }
        public String getName() { return name; }
        public String getServiceType() { return serviceType; }
        public int getEstimatedServiceTime() { return estimatedServiceTime; }

        @Override
        public String toString() {
            return String.format("[%s] %-10s | %-15s | %2d mins",
                    studentNo, name, serviceType, estimatedServiceTime);
        }
    }

    private static class Node {
        Student student;
        Node next;

        Node(Student student) {
            this.student = student;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public StudentLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Insert at Beginning
    public void insertAtBeginning(Student student) {
        Node newNode = new Node(student);
        newNode.next = head;
        head = newNode;
        size++;
        System.out.println("Inserted at beginning: " + student.getName());
    }

    // Insert at End
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

    // Insert at Specified Position (1-based index)
    public void insertAtPosition(Student student, int position) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position: " + position);
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
        System.out.println("Inserted " + student.getName() + " at position " + position);
    }

    // Delete Student by Student Number
    public boolean deleteStudent(String studentNo) {
        if (head == null) {
            System.out.println("List is empty.");
            return false;
        }

        if (head.student.getActiveSheetNo().equals(studentNo)) {
            head = head.next;
            size--;
            System.out.println("Deleted record with Student No: " + studentNo);
            return true;
        }

        Node current = head;
        while (current.next != null && !current.next.student.getActiveSheetNo().equals(studentNo)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            size--;
            System.out.println("Deleted record with Student No: " + studentNo);
            return true;
        }

        System.out.println("Student record with No: " + studentNo + " not found.");
        return false;
    }

    // Search Student by Student Number
    public Student searchStudent(String studentNo) {
        Node current = head;
        while (current != null) {
            if (current.student.getActiveSheetNo().equals(studentNo)) {
                return current.student;
            }
            current = current.next;
        }
        return null;
    }

    // Display / Traversal
    public void displayStudents() {
        if (head == null) {
            System.out.println("No student records available.");
            return;
        }

        System.out.println("\n--- Student Service Records (Singly Linked List) ---");
        Node current = head;
        int pos = 1;
        while (current != null) {
            System.out.printf("Pos %d: %s%n", pos++, current.student);
            current = current.next;
        }
        System.out.println("Total Records: " + size + "\n");
    }

    public int getSize() {
        return size;
    }
}