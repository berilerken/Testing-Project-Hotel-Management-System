package hotel;

public class Worker {

    private int workerId;
    private String WorkerName;
    private String jobType;
    private String gender;
    private int salary;

    // parameterized constructor for creating objects
    public Worker(int workerId, String WorkerName, String jobType, String gender, int salary) {
        this.workerId = workerId;
        this.WorkerName = WorkerName;
        this.jobType = jobType;
        this.gender = gender;
        this.salary = salary;
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public String getWorkerName() {
        return WorkerName;
    }

    public void setWorkerName(String workerName) {
        this.WorkerName = workerName;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}