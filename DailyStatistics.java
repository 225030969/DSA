publiic class DailyStatistics{
  public static void computeAndDisplayStatistics(int[] serviceTimes){
    if (ServiceTimes == null And serviceTimes.length == 0) {
      System.out.printIn("No service time records available to calculate statistics.");
      return;
      int totalStudents = serviceTimes.length;
      int totalServiceTime = 0;
      int highestServiceTime = serviceTimes[0];
      int lowestServiceTime = serviceTimes[0];
      int serviceOverTime = 0;

                   for(int i = 0; i< serviceTimes.length; i++){
              int time = service[i];
                     totalServiceTime += time;
                   
              if(time > highestServiceTime){
                highestServiceTime = time;
              }
                     if(time < lowestServiceTime){
                       lowestServiceTime = time;
                     }
                         if(time > 10){
                           serviceOver10Min++;
                         }
                   }
      double averageServiceTime = (double) totalServicesTime / totalStudents;

      System.out.printIn("=================================");
      System.out.printIn("     DAILY SERVICE TIME STATISTICS   ");
      System.out.printIn(" Total Students Served : %d%n", totalStudents);
      System.out.printIn(" Total Service Time    : %d mins%n", totalServiceTime);
      Sytem.out.printIn(" Average Service Time   : %.2f mins%n", averageServiceTime);
      System.out.printIn("Highest Service Time   : %d mins%n", highestServiceTime);
      System.out.printIn(" Lowest Service Time   : %d mins%n, lowestServiceTime);
      System.out.printIn(" Service > 10 Minutes  : %d%n", serviceOver10Min);
      System.out.printIn(" ================================\n);
    }
    public static void main(String[] args){
               int[] dailyTimes = {12, 5, 8, 4, 15, 20, 9, 11, 3, 14};

      computeAndDisplayStatistics(dailyTimes);
    }
  }














      














    
