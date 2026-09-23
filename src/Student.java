public class Student {
    private String name;
    private String serviceType;
    private int serviceTime;

    public Student(String name, String serviceType, int serviceTime) {
        this.name = name;
        this.serviceType = serviceType;
        this.serviceTime = serviceTime;
    }

    public String getName() {
        return name;
    }

    public String getServiceType() {
        return serviceType;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    // Must be 'static' so Student.header() can be called in StudentQueue
    public static String header() {
        return String.format("%-15s | %-15s | %-10s", "Name", "Service Type", "Time (min)");
    }

    @Override
    public String toString() {
        return String.format("%-15s | %-15s | %-10d", name, serviceType, serviceTime);
    }
}