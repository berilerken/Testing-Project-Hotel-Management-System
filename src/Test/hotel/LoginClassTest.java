package hotel;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class LoginClassTest
{

    static List<Customer> arrayList= new ArrayList<>();
    static Customer customer= new Customer(1,"Ali","Ankara","343232","customer");

    @Test
    public void save() // PATH1 new customer is addded succesfully.
    {
        arrayList.add(customer);
        int inputID=2,input=1;
        String inputName="Ayşe";
        Customer customer1= new Customer(2,"Ayşe","default address","default phoneNum","default type");
        assertEquals(customer1.getCustName(),inputName);
        assertEquals(customer1.getCustomerID(),inputID);
        System.out.println("NEW CUSTOMER IS ADDED :)");

    }
    @Test
    public void save1() // PATH2
    {
        arrayList.add(customer);
        int input=9; // input value is not 0 or 1 which means it only shows the existing customers.
        assertNotNull(arrayList); // because arraylist is already not null.
        System.out.println("************** EXISTING CUSTOMERS ARE SHOWN **************** ");
            for (int i=0;i< arrayList.size();i++)
                System.out.println(arrayList.get(i));


    }
    @Test
    public void save2() // PATH3
    {
        //inputID and inputName should same with the customer's ıd and name.
        arrayList.add(customer);
        int inputID=1,input=0; // the only customer that arraylist has is customerObject with ıd 1 to continue loop succesfully.
        String inputName="Ali";

            for(int i=0;i<arrayList.size();i++)
            {
                assertEquals(arrayList.get(i).customerID,inputID); // yes they are equal it s true
                assertEquals(arrayList.get(i).custName,inputName); // values are same and method is assertequals so it passes
                boolean flag = arrayList.contains(arrayList.get(i));
                    if(flag)
                    {
                        System.out.println("SUCCESFULL LOGIN IS COMPLETED !!");
                    }

            }

    }
    @Test
    public void save3() // PATH4
    {
        arrayList.add(customer);
        int inputID=1,input=0;
        String inputName="Hasan";

            for(int i=0;i<arrayList.size();i++)
            {
                assertEquals(arrayList.get(i).customerID,inputID); // yes they are equal it s true
                assertNotEquals(arrayList.get(i).custName,inputName);
                // values are not same and method is assertnotequals so it passes and display error message
                    System.out.println("CUSTOMER COULDN'T FOUND !!");

            }

        }

    }
