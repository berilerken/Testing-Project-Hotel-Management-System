package hotel;
import java.util.Collections;
import java.util.List;

public class WorkerAccess {


    // creating an object
    private static WorkerAccess workerAccess = new WorkerAccess();

    WorkerAccess() { }

    // static method to create object
    public static WorkerAccess getInstance() {
        return workerAccess;
    }

    // add employee
    public Worker getWorker(int workerId) {
        return null;
    }

    // list all employees
    public List getAll() {
        return Collections.emptyList();
    }


    public String workerInfo(Worker worker) {
        return worker.getWorkerName()+ worker.getGender()+ worker.getJobType();
    }


    public String updateWorker(Worker worker) {
        worker.setWorkerName("Yasmin");
        return worker.getWorkerName();
    }

    public String deleteWorker(int workerId) {
        workerId = 0;
        return "REMOVED";
    }


    public int getWorkerSalary(int workerId) {
        return 5000;
    }
}
