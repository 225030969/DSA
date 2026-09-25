import java.util.Scanner;

public class D_MainMenu {

    private static A1_Queue waitingQueue = new A1_Queue(50);
    private static A2_LinkedList serviceRecords = new A2_LinkedList();
    private static A4_Statistics statistics = new A4_Statistics();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("====================================================");
        System.out.println("   NUST CAMPUS SERVICE CENTRE SIMULATION");
        System.out.println("   DSA521S - Group 5 Mini-Project 2026");
        System.out.println("====================================================");

        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Select option: ");
            String input = scanner.nextLine().trim();

            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1  -> addStudentToQueue();
                case 2  -> serveNextStudent();
                case 3  -> waitingQueue.displayQueue();
                case 4  -> addServiceRecord();
                case 5  -> serviceRecords.displayStudents();
                case 6  -> searchServiceRecord();
                case 7  -> removeServiceRecord();
                case 8  -> statistics.displayStatistics();
                case 9  -> sortServiceTimes();
                case 10 -> C_Experiment.runFullExperiment();
                case 11 -> {
                    System.out.println("Exiting system. Goodbye!");
                    running = false;
                }
                case 12 -> A3_Postfix.evaluate("5 3 + 2 *");
                case 13 -> runPartBTraces();
                default -> System.out.println("Invalid option. Choose 1-13.");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n========================================");
        System.out.println("        CAMPUS SERVICE CENTRE");
        System.out.println("========================================");
        System.out.println(" 1. Add student to waiting queue");
        System.out.println(" 2. Serve next student");
        System.out.println(" 3. Display waiting students");
        System.out.println(" 4. Add student service record");
        System.out.println(" 5. Display student service records");
        System.out.println(" 6. Search for student record");
        System.out.println(" 7. Remove student record");
        System.out.println(" 8. Display daily statistics");
        System.out.println(" 9. Sort service times");
        System.out.println("10. Run sorting experiment");
        System.out.println("11. Exit");
        System.out.println("----------------------------------------");
        System.out.println("12. Postfix Stack Demo (Task A3)");
        System.out.println("13. Part B Sorting Traces");
        System.out.println("========================================");
    }

    private static void addStudentToQueue() {
        System.out.print("Student Number: ");
        String num = scanner.nextLine().trim();
        System.out.print("Name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Service Type: ");
        String service = scanner.nextLine().trim();
        System.out.print("Estimated Service Time (minutes): ");
        int time = Integer.parseInt(scanner.nextLine().trim());

        waitingQueue.enqueue(new Student(num, name, service, time));
    }

    private static void serveNextStudent() {
        Student served = waitingQueue.dequeue();
        if (served != null) {
            statistics.addServiceTime(served.getServiceTime());
            serviceRecords.insertStudent(served);
            System.out.println("Service recorded in statistics and linked list.");
        }
    }

    private static void addServiceRecord() {
        System.out.print("Student Number: ");
        String num = scanner.nextLine().trim();
        System.out.print("Name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Service Type: ");
        String service = scanner.nextLine().trim();
        System.out.print("Estimated Service Time (minutes): ");
        int time = Integer.parseInt(scanner.nextLine().trim());

        Student s = new Student(num, name, service, time);

        System.out.println("Insert where?");
        System.out.println("  1. Beginning");
        System.out.println("  2. End");
        System.out.println("  3. Specific position");
        System.out.print("Choice: ");
        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1" -> serviceRecords.insertAtBeginning(s);
            case "2" -> serviceRecords.insertAtEnd(s);
            case "3" -> {
                System.out.print("Position: ");
                int pos = Integer.parseInt(scanner.nextLine().trim());
                serviceRecords.insertAtPosition(s, pos);
            }
            default -> serviceRecords.insertAtEnd(s);
        }
    }

    private static void searchServiceRecord() {
        System.out.print("Enter Student Number: ");
        String num = scanner.nextLine().trim();
        serviceRecords.searchStudent(num);
    }

    private static void removeServiceRecord() {
        System.out.print("Enter Student Number to remove: ");
        String num = scanner.nextLine().trim();
        serviceRecords.deleteStudent(num);
    }

    private static void sortServiceTimes() {
        int[] times = statistics.getServiceTimesCopy();
        if (times.length == 0) {
            System.out.println("No service times recorded yet.");
            return;
        }

        System.out.println("Current service times:");
        B_SortingAlgorithms.printArray(times);

        System.out.println("Choose algorithm:");
        System.out.println("  1. Selection Sort");
        System.out.println("  2. Insertion Sort");
        System.out.println("  3. Merge Sort");
        System.out.println("  4. Quick Sort");
        System.out.print("Choice: ");
        String c = scanner.nextLine().trim();

        int[] copy = B_SortingAlgorithms.copyArray(times);
        B_SortingAlgorithms.resetCounters();

        switch (c) {
            case "1" -> B_SortingAlgorithms.selectionSort(copy);
            case "2" -> B_SortingAlgorithms.insertionSort(copy);
            case "3" -> B_SortingAlgorithms.mergeSort(copy);
            case "4" -> B_SortingAlgorithms.quickSort(copy);
            default -> {
                System.out.println("Invalid choice.");
                return;
            }
        }

        System.out.println("Sorted:");
        B_SortingAlgorithms.printArray(copy);
        System.out.println("Comparisons: " + B_SortingAlgorithms.comparisons);
    }

    private static void runPartBTraces() {
        int[] sample = {17, 5, 23, 8, 14, 3, 11, 20, 6, 9};
        B_SortingAlgorithms.selectionSortWithTrace(B_SortingAlgorithms.copyArray(sample));
        B_SortingAlgorithms.insertionSortWithTrace(B_SortingAlgorithms.copyArray(sample));
    }
}