import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class TransactionHandlingJdbc {
public static void main(String []args) throws Exception {
		
		String url="jdbc:mysql://localhost:3306/Lenden";
		String username="root";
		String pass="12345";
	
		try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(Exception e) {
			System.out.println("e.getMessage");
		}
		
		
try {	 
	 Connection con = DriverManager.getConnection( url,username, pass);

	 con.setAutoCommit(false);
	 
	 String debit_query= "Update accounts Set baalnce =baalnce - ? where account_number = ?";
String credit_query= "Update accounts set baalnce = baalnce + ? where account_number =?";

PreparedStatement ps = con.prepareStatement(debit_query);
PreparedStatement ps1 = con.prepareStatement(credit_query);

Scanner scanner =new Scanner(System.in);
System.out.println("Enter  Debit account number: ");
 int debitacc=scanner.nextInt();
 System.out.println("Enter  Debit account number: ");
 int creditacc=scanner.nextInt();
System.out.println("Enter amount ");
double amount =scanner.nextDouble();


if(isSuffecient(con, debitacc, amount)) {

ps.setDouble(1,amount);
ps.setInt(2, 101);

ps1.setDouble(1, amount);
ps1.setInt(2, 102 );

ps.executeUpdate(); 
 ps1.executeUpdate();
 
con.commit();
System.out.println("Transaction Succesfull");
// rowsAffected1 =ps.executeUpdate(); 
//  rowsAffected2= ps1.executeUpdate();
}else {
	con.rollback();
	System.out.println("Transaction Failed-Insufficent balance");
}


 
}catch (Exception e) {
	System.out.println(e.getMessage());
}

}

static  boolean  isSuffecient(Connection con, int account_number, double amount) {
try {
	String query ="Select baalnce from accounts where account_number=?";
	PreparedStatement ps=con.prepareStatement(query);
	ps.setInt(1,account_number);
	ResultSet rs =ps.executeQuery();
	if(rs.next()) {
		 double current_baalnce=rs.getDouble("baalnce");
		 if(amount>current_baalnce) {
			 return false;
		 }else {
			 return true;
			 
		 }
	}
	}catch(Exception e) {
	System.out.println(e.getMessage());
	
} 
return false;



}
}
