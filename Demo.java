import java.sql.*;
public class Demo {
public static void main(String []args) throws Exception {
	
	String url="jdbc:mysql://localhost:3306/demodb1";
	String username="root";
	String pass="12345";
	String query=" select * from employee ";
	
	 Class.forName("com.mysql.cj.jdbc.Driver");
	
	 
 Connection con = DriverManager.getConnection( url,username, pass);
  Statement st = con .createStatement();
   ResultSet rs= st.executeQuery(query);
   
   
    String userData=" ";
 while(  rs.next()){
   userData =rs.getString(2)+ ":" +rs.getInt(1); 
   System.out.println(userData);
 };
  st.close();
  con.close();
  
}

}
