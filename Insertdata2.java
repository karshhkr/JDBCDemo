import java.sql.*;
public class Insertdata2 {
	public static void main(String []args) throws Exception {
		
		String url="jdbc:mysql://localhost:3306/mydb";
		String username="root";
		String pass="12345";
	
		String query=" insert into Students (name, age, marks)values (?,?,?)";
		
		
		
		 Class.forName("com.mysql.cj.jdbc.Driver");
		
try {	 
	 Connection con = DriverManager.getConnection( url,username, pass);
	
	// when we want predefined query we used PreparedStatement when you dont know  the col in the table 
	 PreparedStatement ps = con .prepareStatement(query);
	  
	// setting up the values for database to get update 
	  ps.setString(1 ,"Anuradha");
	  ps.setInt(2 ,47);
	  ps.setDouble(3, 76.7 );
	 
	  int rowsAffected = ps.executeUpdate();// we update the query through the java code so the update query is used 
	   if(rowsAffected>0) {
	 System.out.println(rowsAffected +"data inserted" );
	   }else {
		   System.out.println(rowsAffected +"data not  inserted" );
	   }
}catch (Exception e) {
	System.out.println(e.getMessage());
}
	
}
}