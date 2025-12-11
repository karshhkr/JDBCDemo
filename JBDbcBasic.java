
import java.sql.*;


public class JBDbcBasic {
	
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
		String query = "Insert into Students";
		 ResultSet rs= st.executeQuery(query);
		while(rs.next()) {
			int id =rs.getInt("id");
			String name =rs.getString("name");
			int age = rs.getInt("age");
			double marks= rs.getDouble("marks");
			System.out.println("ID "+id);
			System.out.println("NAME "+name);
			System.out.println("AGE "+age);
			System.out.println("MARKS "+marks);
		}
			
		
		
		
	}catch(Exception e ) {
		System.out.println(e.getMessage());
	}
}
}
