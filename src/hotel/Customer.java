package hotel;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {

	int customerID;
	String custName;
	String addr;
	String phone;
	String Type;
	static int j=0;
	static Customer []customers= new Customer[3];
	
	
	Customer()
	{
		
	}
	
	
	public Customer(int customerID, String custName, String addr, String phone, String Type) {
		super();
		this.customerID = customerID;
		this.custName = custName;
		this.addr = addr;
		this.phone = phone;
		this.Type = Type;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public static int getJ() {
		return j;
	}

	public static void setJ(int j) {
		Customer.j = j;
	}

	public void printCustomer()
	{
		System.out.println("Customer Name : "+this.custName);
		System.out.println("Customer Address : "+this.addr);
		System.out.println("Customer Phone : "+this.phone);
	}
	
	
	public void addCustomer(String oper,Customer cust)
	{
		PreparedStatement ps = null;
    	ResultSet result = null;
		try {
	    	 if(oper=="i")
	         {   
	    		GetConnection connect=new GetConnection();
	    		Connection conn=connect.getConnection();
	        	 ps=conn.prepareStatement("INSERT INTO customer (customerName, address, phoneNo, type) VALUES (?,?,?,?)");
                 ps.setString(1,cust.custName);
	             ps.setString(2,cust.addr);
	             ps.setString(3,cust.phone);
	             ps.setString(4,cust.Type);

	             
	             if(ps.executeUpdate()>0)
	             {
	            	 JOptionPane.showMessageDialog(null, "New Customer Added");
	             }
	         }
	    	}
	    	
	    	catch(Exception ex)
	    	{
	    		ex.printStackTrace();
	    	}
	}
	
	
	public void deleteCustomer(String oper,Customer cust)
	{
		 PreparedStatement ps = null;
		    ResultSet result = null;
				try {
			    	 if(oper=="d")
			         {   
			    		GetConnection connect=new GetConnection();
			    		Connection conn=connect.getConnection();
			        	 ps=conn.prepareStatement("DELETE FROM customer where customerName=?");
			        	 ps.setString(1,cust.custName);
			        	 
			             ps.executeUpdate();
			                JOptionPane.showMessageDialog(null,"Deleted Sucessfully");
			           
			         }
			    	}
			    	
			    	catch(Exception ex)
			    	{
			    		ex.printStackTrace();
			    	}
	}
	//////////////////////////////////////MUTATION TEST METHODS///////////////////////////////////////////////
	public static boolean isValid(String phoneNumber)
	{
		String regex = "[0-9]+";
		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(phoneNumber);
		if(m.matches()==true)
			return true;
		return false;
	}
	public static boolean isValid1(String phoneNumber)
	{
		String regex = "[0-9]+";
		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(phoneNumber);
		if(m.matches()!=true) // == changed as a != (not equals)
			return true;
		return false;
	}
	public static boolean isValid2(String phoneNumber)
	{
		String regex = "[0-9]+";
		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(phoneNumber);
		if(m.matches()==true)
			return false; // logic is changed with the opposite condition
		return true;
	}



	@Override
	public String toString()
	{
		return "Customer ID:"+customerID+" Customer Name:"+custName+" Customer Address:"+addr;
	}

	public static void customerInfo()
	{
		Customer customer= new Customer(1,"Ayşe","İzmir","03924984238","customer");
		Customer customer1= new Customer(2,"Ali","İstanbul","945989334","intern");
		Customer customer2= new Customer(3,"Asiye","Kenya","6143436525","intern");
		customers[0]=customer;
		customers[1]=customer1;
		customers[2]=customer2;
		System.out.println(customers[1]);

	}

	public static void main(String[] args)
	{
		customerInfo();
	}
	
	
}
