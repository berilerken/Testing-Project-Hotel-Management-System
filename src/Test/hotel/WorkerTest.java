package hotel;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WorkerTest
{

    private static WorkerAccess mockWorkerAccess;
    private static Worker worker;
    private static Worker worker1;

    @Test
    public void whenCreateSpy_thenCreate() {
        Map spyWorkerMap = Mockito.spy(new HashMap());
        Worker worker3 = new Worker(1, "Beril", "CEO", "Female", 100000);
        spyWorkerMap.put("1", "Beril");
        Mockito.verify(spyWorkerMap).put("1", "Beril");

        assertEquals(worker3.getWorkerName(), spyWorkerMap.get("1"));
    }

    @BeforeClass
    public static void initialize()
    {

        // set WorkerAccess as a mock object
        mockWorkerAccess = mock(WorkerAccess.class);

        // create an worker object
        worker = new Worker(1, "Batuhan Çayırtepe", "CEO", "Male", 100000);

        // create another worker object
        worker1 = new Worker(2, "Kaan Arı", "CTO", "Male", 110000);

        // stubbing is done for test cases
        when(mockWorkerAccess.getAll()).thenReturn(Arrays.asList(worker, worker1));
        when(mockWorkerAccess.getWorker(1)).thenReturn(worker);
        when(mockWorkerAccess.workerInfo(worker1)).thenReturn(worker1.getWorkerName());
        when(mockWorkerAccess.updateWorker(worker1)).thenReturn(worker1.getWorkerName());
        when(mockWorkerAccess.deleteWorker(1)).thenReturn("REMOVED");

    }

    @Test
    public void getAllTest()
    {
        List allEmployees = mockWorkerAccess.getAll();
        assertNotNull(allEmployees);
        assertEquals(2, allEmployees.size());
    }

    @Test
    public void getEmployeeTest()
    {
        int wId = 1;
        Worker worker = mockWorkerAccess.getWorker(wId);

        assertNotNull(worker);
        assertEquals(1, worker.getWorkerId());
        assertEquals("Batuhan Çayırtepe", worker.getWorkerName());
        assertEquals("CEO", worker.getJobType());
        assertEquals("Male", worker.getGender());
    }

    @Test
    public void addEmployeeTest()
    {
        String employeeName = mockWorkerAccess.workerInfo(worker1);

        assertNotNull(employeeName);
        assertEquals("Kaan Arı", employeeName);
    }

    @Test
    public void updateEmployeeTest()
    {
        String employeeName = mockWorkerAccess.updateWorker(worker1);

        assertNotNull(employeeName);
        assertEquals("Kaan Arı", employeeName);
    }

    @Test
    public void deleteEmployeeTest()
    {
        String status = mockWorkerAccess.deleteWorker(1);
        assertEquals("REMOVED", status);
    }
}