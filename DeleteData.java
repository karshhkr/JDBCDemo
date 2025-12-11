import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeleteData {
	
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
		String query = ("Delete from Students where id  =2");
		 int  rowsAffected  = st.executeUpdate(query);
		if(rowsAffected>0) {
			System.out.println("DATA Deleted succesfully");
		}else {
			System.out.println("DATA not Deleted");
		}

}catch(Exception e ) {
	System.out.println(e.getMessage());
}
}
}