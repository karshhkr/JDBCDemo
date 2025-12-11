import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;
public class JdbcBatchProcessing{
	public static void main(String []args) throws Exception {
		
		String url="jdbc:mysql://localhost:3306/mydb";
		String username="root";
		String pass="12345";
	
	
		
		
		
		 Class.forName("com.mysql.cj.jdbc.Driver");
		
try {	 
	 Connection con = DriverManager.getConnection( url,username, pass);
	
	 String query=" insert into Students (name, age, marks)values (?, ?, ?)"; 
	 PreparedStatement ps=con.prepareStatement(query);
	 Scanner scanner =new Scanner(System.in);
			while (true) {
				System.out.print("Enter name: ");
	             String name =scanner.next()	;
	             System.out.print("Enter age: ");
			     int age =scanner.nextInt();
			     System.out.print("Enter marks: ");			
			     Double marks =scanner.nextDouble();
			     System.out.print("Enter more Data(y/n)");
			     String choice= scanner.next();
			 	ps.setString(1, name);
			 	ps.setInt(2, age);
			 	ps.setDouble(3, marks);
			 	
			 	ps.addBatch();
			 	if(choice.toUpperCase().equals("N")) {
			    	  break;
			      }
			}

  int[] arr = ps.executeBatch();

   for (int i =0; i<arr.length;i++) {
	   if(arr[i]==0) {
		   System.out.println("Query: "+i+ "not execute sucessfully");
	   }
   }
}catch (Exception e) {
	System.out.println(e.getMessage());
}
	
}
}