import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Updatedata {
	
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
		String query = String.format("Update  Students set marks =%f where id =%d",89.5,2);
		 int  rowsAffected  = st.executeUpdate(query);
		if(rowsAffected>0) {
			System.out.println("DATA Upated succesfully");
		}else {
			System.out.println("DATA not Upadated");
		}

}catch(Exception e ) {
	System.out.println(e.getMessage());
}
}
}