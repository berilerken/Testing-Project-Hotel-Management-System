package hotel;


import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {
	
	Connection connect;
	
	public Connection getConnection()
	{   
	
		String url,user,pwd;
		url="jdbc:mysql://localhost/database?serverTimezone=UTC";
		//url="jdbc:mysql://localhost:3306";
		user="root";
		pwd="Yasmin5535--";
	
		try {
		
			 connect =DriverManager.getConnection(url, user, pwd);
           
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return connect;
		
	}

}
