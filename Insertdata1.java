import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Insertdata1 {
	
	 private static final String url="jdbc:mysql://localhost:3306/mydb";
	private static final String username="root";
	private static final String password="12345";
	
	
	
public static void main(String[]args) throws Exception{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	}
	catch(Exception e) {
	System.out.println(e.getMessage());
		
	}
try {
		
		Connection  con  = DriverManager.getConnection(url, username, password); 
		Statement st = con.createStatement();
		String query = String.format("Insert into Students (name, age, marks) values('%s', %o, % 2f)","Anuradha", 47, 78.8);
		 int  rowsAffected  = st.executeUpdate(query);
		if(rowsAffected>0) {
			System.out.println("DATA inserted succesfully");
		}else {
			System.out.println("DATA not inserted");
		}

}catch(Exception e ) {
	System.out.println(e.getMessage());
}
}
}