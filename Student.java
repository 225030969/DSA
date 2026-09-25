public class Student {

    private String studentNo;
    private String name;
    private String serviceType;
    private int serviceTime;

   
    public Student(String studentNo, String name, String serviceType, int serviceTime) {
        this.studentNo = studentNo;
        this.name = name;
        this.serviceType = serviceType;
        this.serviceTime = serviceTime;
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

    public int getServiceTime() {
        return serviceTime;
    }


    @Override
    public String toString() {
        return studentNo + " | " + name + " | " + serviceType + " | " + serviceTime + " min";
    }
}