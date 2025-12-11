import java.sql.*;

// we create an EmployeeDAO object create to bring employee from clas  DB 

public class JdbcDAO {
public static void main (String [] args)throws Exception {
	
	EmployeeDAO dao = new EmployeeDAO();// Data Access Object(DAO)
	
    Employee e1 = dao.getEmplpoyee(11);// method call of DAO to bring employeeid of employee

	System.out.println(e1.sname);
	
	
	 Employee e2 = new Employee();
	 e2.empid=13;
	 e2.sname="snehal";
	
}
}
 class EmployeeDAO{ // class of DAO
	 public  Employee getEmplpoyee (int empid ) {
		
		 Employee e = new Employee();
		  e.empid=empid;
		  
		  
		  
		  try {
			  String query = "select sname from employee where empid="+empid;
			  
			Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mysqldb","root","12345");
			Statement st= con.createStatement();
			ResultSet rs= st.executeQuery(query);
			 rs.next();
			 String sname =rs.getString("sname");
					 e.sname = sname;
		}
		  
		  
	  catch (Exception ex) {
		System.out.println(ex);
			
		}
			
		  return e;
		  
		 
	 }
	 public void addEmployee(Employee e) {
		 String query = "insert into Employee values(?,?) ";
	 }
 }
  class Employee {
	  int empid ;
	  String sname;
	  
  }
