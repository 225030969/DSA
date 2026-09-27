public class DailyStatistics {

    public static void computeAndDisplayStatistics(int[] serviceTimes) {
        if (serviceTimes == null || serviceTimes.length == 0) {
            System.out.println("No service time records available to calculate statistics.");
            return;
        }

        int totalStudents = serviceTimes.length;
        int totalServiceTime = 0;
        int highestServiceTime = serviceTimes[0];
        int lowestServiceTime = serviceTimes[0];
        int servicesOver10Min = 0;

                for (int i = 0; i < serviceTimes.length; i++) {
            int time = serviceTimes[i];

                       totalServiceTime += time;

                       if (time > highestServiceTime) {
                highestServiceTime = time;
            }

   
            if (time < lowestServiceTime) {
                lowestServiceTime = time;
            }

                       if (time > 10) {
                servicesOver10Min++;
            }
        }

               double averageServiceTime = (double) totalServiceTime / totalStudents;

              System.out.println("=========================================");
        System.out.println("      DAILY SERVICE TIME STATISTICS      ");
        System.out.println("=========================================");
        System.out.printf(" Total Students Served   : %d%n", totalStudents);
        System.out.printf(" Total Service Time      : %d mins%n", totalServiceTime);
        System.out.printf(" Average Service Time    : %.2f mins%n", averageServiceTime);
        System.out.printf(" Highest Service Time    : %d mins%n", highestServiceTime);
        System.out.printf(" Lowest Service Time     : %d mins%n", lowestServiceTime);
        System.out.printf(" Services > 10 Minutes   : %d%n", servicesOver10Min);
        System.out.println("=========================================\n");
    }

    public static void main(String[] args) {
               int[] dailyTimes = {12, 5, 8, 4, 15, 20, 9, 11, 3, 14};

        computeAndDisplayStatistics(dailyTimes);
    }
}
