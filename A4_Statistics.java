public class A4_Statistics {

    private int[] serviceTimes;
    private int count;
    private int capacity;

    public A4_Statistics() {
        this.capacity = 100;
        this.serviceTimes = new int[capacity];
        this.count = 0;
    }

    public void addServiceTime(int time) {
        if (count >= capacity) {
            int[] newArr = new int[capacity * 2];
            for (int i = 0; i < count; i++) {
                newArr[i] = serviceTimes[i];
            }
            serviceTimes = newArr;
            capacity = capacity * 2;
        }
        serviceTimes[count] = time;
        count++;
    }

    public int getCount() {
        return count;
    }

    public int[] getServiceTimesCopy() {
        int[] copy = new int[count];
        for (int i = 0; i < count; i++) {
            copy[i] = serviceTimes[i];
        }
        return copy;
    }

    public void displayStatistics() {
        if (count == 0) {
            System.out.println("No students have been served yet.");
            return;
        }

        int totalServiceTime = 0;
        int highest = serviceTimes[0];
        int lowest = serviceTimes[0];
        int longerThan10 = 0;

        for (int i = 0; i < count; i++) {
            int t = serviceTimes[i];
            totalServiceTime += t;

            if (t > highest) highest = t;
            if (t < lowest) lowest = t;
            if (t > 10) longerThan10++;
        }

        double average = (double) totalServiceTime / count;

        System.out.println("\n===== DAILY SERVICE STATISTICS =====");
        System.out.println("Total students served      : " + count);
        System.out.println("Total service time         : " + totalServiceTime + " minutes");
        System.out.printf ("Average service time       : %.2f minutes%n", average);
        System.out.println("Highest service time       : " + highest + " minutes");
        System.out.println("Lowest service time        : " + lowest + " minutes");
        System.out.println("Services longer than 10 min: " + longerThan10);
        System.out.println("====================================\n");
    }
}