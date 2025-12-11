import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Updatedata2 {
	public static void main(String []args) throws Exception {
		
		String url="jdbc:mysql://localhost:3306/mydb";
		String username="root";
		String pass ="12345";
		String query=" update   Students set marks =?  where id=?";
		
		
		
		 Class.forName("com.mysql.cj.jdbc.Driver");
		
		try { 
	 Connection con = DriverManager.getConnection( url,username, pass);
	
	// when we want predefined query we used PreparedStatement when you dont know  the col in the table 
	 PreparedStatement ps = con .prepareStatement(query);
   ps.setDouble(1,90.5);
   ps.setInt(2, 3);
   
	  int rowsAffected = ps.executeUpdate();// we update the query through the java code so the update query is used 
	   if(rowsAffected>0) {
	 System.out.println(rowsAffected +"data Updated" );
	   }else {
		   System.out.println(rowsAffected +"data not Updated" );
	   }
	
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

}
}