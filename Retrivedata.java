import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Retrivedata {
	public static void main(String []args) throws Exception {
		
		String url="jdbc:mysql://localhost:3306/mydb";
		String username="root";
		String pass ="12345";
		String query=" Select marks from  Students where id =?";
		
		
		
		 Class.forName("com.mysql.cj.jdbc.Driver");
		
		try { 
	 Connection con = DriverManager.getConnection( url,username, pass);
	
	// when we want predefined query we used PreparedStatement when you dont know  the col in the table 
	 PreparedStatement ps = con .prepareStatement(query);
   ps.setInt(1,1);
   

	 ResultSet rs =ps.executeQuery();
	 if(rs.next()) {
		 double marks=rs.getDouble("marks");
		 System.out.println("marks:"+marks);
	 }
	 else {
		 System.out.println("Marks not found! ");
	 }
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

}
}