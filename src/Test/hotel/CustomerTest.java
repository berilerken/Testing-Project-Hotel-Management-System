package hotel;
import org.junit.Assert;
import org.junit.Test;

import static hotel.Customer.customers;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class CustomerTest
{

    @Test
    public void addCustomer()
    {
        //int customerID, String custName, String addr, String phone, String Type
        Customer customer= new Customer(100,"Aras","Yenimahalle","05301066565","customer");
        Assert.assertEquals("Ankara",customer.addr);

    }
    @Test
    public void addCustomer1()
    {
        //int customerID, String custName, String addr, String phone, String Type
        Customer customer= new Customer(101,"Atakan","Eşrefpaşa","05545263938","customer");
        Assert.assertEquals("Atakan",customer.custName);

    }
    @Test
    public void addCustomer2()
    {
        //int customerID, String custName, String addr, String phone, String Type
        Customer customer= new Customer(102,"Berke","Etlik","05399097989","customer");
        Assert.assertNotSame("Burak",customer.custName);


    }
    @Test
    public void addCustomer3()
    {
        //int customerID, String custName, String addr, String phone, String Type
        Customer customer1= new Customer();
        Assert.assertNotNull(customer1.custName);

    }
    @Test
    public void addCustomer4()
    {
        //int customerID, String custName, String addr, String phone, String Type
        Customer customer1= new Customer();
        //Assert.assertNull(customer.customerID); -->  a value of primitive type will be never null thats why it always fails.
        Assert.assertNull(customer1.custName);

    }
    @Test
    public void addCustomer5()
    {
        //int customerID, String custName, String addr, String phone, String Type
        Customer customer= new Customer(103,"Bora","Bornova","05532628969","customer");
        assertEquals("05532628969", customer.phone); // --> true
        //Assert.assertTrue(customer.phone.equals("05532628999")); // --> false
    }
    @Test
    public void addCustomer6()
    {
        //int customerID, String custName, String addr, String phone, String Type
        Customer customer= new Customer(104,"Ekrem","Eryaman","05548756326","customer");
        assertNotEquals("EKREM", customer.custName);
        // we observed that if there is a difference between the same word's writing type such as EKREM or Ekrem
    }

    @Test
    public void getPhone()
    {
        Customer customer= new Customer(105,"Arda","Buca","05421363635","customer");
        assertEquals("05236985263", customer.getPhone());
    }

    @Test
    public void setType()
    {
        Customer customer= new Customer(106,"Nejat","Atakum","03629658584","customer");
        customer.setType("employee");
        Assert.assertNotSame("customer",customer.getType()); // they are different so not same condition is true
    }
    @Test
    public void addCustomer7()
    {
        Customer customer= new Customer(107,"Metehan","Karabağlar","05236985236","customer");
        String []arr= new String[4];
        arr[0]=customer.custName;
        arr[1]=customer.addr;
        arr[2]=customer.phone;
        arr[3]=customer.Type;
        String []arrCompare= new String[]{"MeteHAN","Karabağlar","05236985236","customer"};
        //int customerID, String custName, String addr, String phone, String Type
        Assert.assertArrayEquals(arr,arrCompare);

    }
////////////////////////////////////MUTATION TEST METHODS///////////////////////////////////////////////
    @Test
    public void addCustomer8()
    {
        //int customerID, String custName, String addr, String phone, String Type
        Customer customer= new Customer(104,"Ekrem","Eryaman","05548756326","customer");
        if(customer.customerID==104 && customer.custName!=null)
            System.out.println("VALID CUSTOMER");
        else
            System.out.println("INVALID CUSTOMER");

    }
    @Test
    public void addCustomer9() // mutation test gave invalid customer output
    {
        //int customerID, String custName, String addr, String phone, String Type
        Customer customer= new Customer(104,"Ekrem","Eryaman","05548756326","customer");
        if(customer.customerID!=104 && customer.custName!=null)
            System.out.println("VALID CUSTOMER");
        else
            System.out.println("INVALID CUSTOMER");

    }
    @Test
    public void addCustomer10() // mutation test gave invalid customer output
    {
        //int customerID, String custName, String addr, String phone, String Type
        Customer customer= new Customer(104,"Ekrem","Eryaman","05548756326","customer");
        if(customer.customerID!=104 && customer.custName==null)
            System.out.println("VALID CUSTOMER");
        else
            System.out.println("INVALID CUSTOMER");

    }


}