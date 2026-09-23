public class TaskA1Demo {
    public static void main(String[] args) {
        ServiceQueue queue = new ServiceQueue();

        System.out.println("=========================================");
        System.out.println(" TASK A1: QUEUE DEMONSTRATION");
        System.out.println("=========================================\n");
        System.out.println("--- Arriving Students (Enqueue) ---");
        queue.enqueue(new Student("221045678", "Maria", "Registration", 12));
        queue.enqueue(new Student("222034512", "Tomas", "Student Card", 5));
        queue.enqueue(new Student("223041876", "Ndapewa", "Fees", 8));
        queue.enqueue(new Student("221067341", "Simon", "Documents", 4));
        queue.enqueue(new Student("224012345", "Johannes", "Academic", 10));
        queue.enqueue(new Student("225098765", "Petrina", "Registration", 15));
        queue.displayQueue();
        System.out.println("Next student to be served (Peek): " + queue.peek().getName() + "\n");
        System.out.println("--- Serving Students (Dequeue) ---");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.displayQueue();
    }
}
