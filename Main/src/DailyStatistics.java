public class DailyStatistics {
    public static void computeAndDisplayStatistics(int[] serviceTimes) {
        if (serviceTimes == null || serviceTimes.length == 0) {
            System.out.println("No service time data available.");
            return;
        }

        int totalStudents = serviceTimes.length;
        int totalServiceTime = 0;
        int highest = serviceTimes[0];
        int lowest = serviceTimes[0];
        int countLongerThan10 = 0;

        for (int i = 0; i < serviceTimes.length; i++) {
            int time = serviceTimes[i];
            totalServiceTime += time;

            if (time > highest) highest = time;
            if (time < lowest) lowest = time;
            if (time > 10) countLongerThan10++;
        }

        double averageServiceTime = (double) totalServiceTime / totalStudents;

        System.out.println("\n=============================================");
        System.out.println("       DAILY SERVICE TIME STATISTICS         ");
        System.out.println("=============================================");
        System.out.println(" Total Students Served            : " + totalStudents);
        System.out.println(" Total Service Time               : " + totalServiceTime + " mins");
        System.out.println(" Average Service Time             : " + String.format("%.2f", averageServiceTime) + " mins");
        System.out.println(" Highest Service Time             : " + highest + " mins");
        System.out.println(" Lowest Service Time              : " + lowest + " mins");
        System.out.println(" Services Longer Than 10 Minutes  : " + countLongerThan10);
        System.out.println("=============================================");
    }
}
