package hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginClass
{
    static List<Customer> arrayList= new ArrayList<>();
    static Customer customer= new Customer(1,"Ali","Ankara","343232","customer");
    static List<String> names= new ArrayList<>();

    public static void save1()
    {
        arrayList.add(customer);
        Scanner scanner= new Scanner(System.in);
        int inputID,input;
        String inputName;
        System.out.println("Welcome to the system. Do you have account already?\nPress 0 --> YES\nPress 1 --> NO");
        input = scanner.nextInt();
        if(input==0)
        {
            System.out.println("Please enter your ID : ");
            inputID= scanner.nextInt();
            System.out.println("Please enter your Name : ");
            inputName=scanner.next();
            for(int i=0;i<arrayList.size();i++)
            {
                if(arrayList.get(i).customerID==inputID && arrayList.get(i).custName.equals(inputName))
                {
                    boolean flag = arrayList.contains(arrayList.get(i));
                    if(flag)
                    {
                        System.out.println("SUCCESFULL LOGIN IS COMPLETED !!");
                        System.exit(0);
                    }

                }
                else
                    System.out.println("CUSTOMER COULDN'T FOUND !!");

            }

        }
        else if(input==1)
        {
            System.out.println("Please enter your ID : ");
            inputID= scanner.nextInt();
            System.out.println("Please enter your Name : ");
            inputName=scanner.next();
            Customer customer1= new Customer(inputID,inputName,"default address","default phoneNum","default type");
            arrayList.add(customer1);
            System.out.println("NEW CUSTOMER IS ADDED :)");
            save1();
        }
        else
        {
            System.out.println("************** EXISTING CUSTOMERS ARE SHOWN **************** ");
            for (Customer value : arrayList) System.out.println(value);
        }



    }
    public static void save(Customer customer)
    {
        for(int i=0;i<arrayList.size();i++)
        {
            if(arrayList.get(i).customerID!=customer.customerID && arrayList.get(i).custName!=(customer.custName))
            {
                    System.out.println("New customer Succesfully saved.");
                    arrayList.add(customer);
            }
            else
                System.out.println("Customer is already exist.");

        }

    }


    public static void main(String[] args)
    {
        save1();
    }
}
