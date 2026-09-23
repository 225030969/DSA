import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomQueue queue = new CustomQueue();
        CustomLinkedList recordList = new CustomLinkedList();
        queue.enqueue(new Student("221045678", "Maria", "Registration", 12));
        queue.enqueue(new Student("222034512", "Tomas", "Student Card", 5));
        queue.enqueue(new Student("223041876", "Ndapewa", "Fees", 8));
        queue.enqueue(new Student("221067341", "Simon", "Documents", 4));

        recordList.insertAtEnd(new Student("221045678", "Maria", "Registration", 12));
        recordList.insertAtEnd(new Student("222034512", "Tomas", "Student Card", 5));

        boolean running = true;

        while (running) {
            System.out.println("\n=================================================");
            System.out.println("   CAMPUS SERVICE CENTRE MANAGEMENT SYSTEM       ");
            System.out.println("=================================================");
            System.out.println(" 1. Add student to waiting queue (enqueue)");
            System.out.println(" 2. Serve next student (dequeue)");
            System.out.println(" 3. Display waiting students");
            System.out.println(" 4. Add student service record (Linked List)");
            System.out.println(" 5. Display student service records");
            System.out.println(" 6. Search for student record");
            System.out.println(" 7. Remove student record");
            System.out.println(" 8. Display daily statistics");
            System.out.println(" 9. Sort service times");
            System.out.println("10. Run sorting experiment");
            System.out.println("11. Exit");
            System.out.println("=================================================");
            System.out.print("Select option (1-11): ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Enter Student No: ");
                    String qNo = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String qName = scanner.nextLine();
                    System.out.print("Enter Service Type: ");
                    String qType = scanner.nextLine();
                    System.out.print("Enter Est. Time (mins): ");
                    int qTime = Integer.parseInt(scanner.nextLine());
                    queue.enqueue(new Student(qNo, qName, qType, qTime));
                    break;

                case "2":
                    Student served = queue.dequeue();
                    if (served != null) {
                        System.out.println("Now Serving: " + served);
                    }
                    break;

                case "3":
                    queue.displayQueue();
                    break;

                case "4":
                    System.out.print("Enter Student No: ");
                    String rNo = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String rName = scanner.nextLine();
                    System.out.print("Enter Service Type: ");
                    String rType = scanner.nextLine();
                    System.out.print("Enter Est. Time (mins): ");
                    int rTime = Integer.parseInt(scanner.nextLine());
                    recordList.insertAtEnd(new Student(rNo, rName, rType, rTime));
                    break;

                case "5":
                    recordList.displayStudents();
                    break;

                case "6":
                    System.out.print("Enter Student No to Search: ");
                    String searchNo = scanner.nextLine();
                    Student found = recordList.searchStudent(searchNo);
                    if (found != null) {
                        System.out.println("Found Record: " + found);
                    } else {
                        System.out.println("No record found for Student No: " + searchNo);
                    }
                    break;

                case "7":
                    System.out.print("Enter Student No to Remove: ");
                    String delNo = scanner.nextLine();
                    boolean deleted = recordList.deleteStudent(delNo);
                    if (deleted) {
                        System.out.println("Successfully removed record for: " + delNo);
                    } else {
                        System.out.println("Record not found.");
                    }
                    break;

                case "8":
                    int[] sampleTimes = {12, 5, 8, 4, 15, 20, 9, 11, 3, 14};
                    DailyStatistics.computeAndDisplayStatistics(sampleTimes);
                    break;

                case "9":
                    int[] testArray = {17, 5, 23, 8, 14, 3, 11, 20, 6, 9};
                    System.out.println("\nSorting service times array: " + java.util.Arrays.toString(testArray));
                    SortingAlgorithms.selectionSort(testArray.clone());
                    System.out.println("Sorted Result: " + java.util.Arrays.toString(testArray));
                    break;

                case "10":
                    SortingAlgorithms.runExperiment();
                    break;

                case "11":
                    running = false;
                    System.out.println("Exiting System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid selection! Please enter a number between 1 and 11.");
            }
        }
        scanner.close();
    }
}
