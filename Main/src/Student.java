public class Student {
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

    public String getStudentNo() {
        return studentNo;
    }

    public String getName() {
        return name;
    }

    public String getServiceType() {
        return serviceType;
    }

    public int getEstimatedServiceTime() {
        return estimatedServiceTime;
    }

    @Override
    public String toString() {
        return String.format("[%s] %-10s | %-15s | %2d mins",
                studentNo, name, serviceType, estimatedServiceTime);
    }
}
