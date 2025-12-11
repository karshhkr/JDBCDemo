//  while  creating the object before it will load the class it will call the static method 
//while create the object it will calls the instance block

//PQR is parathesis , Quotes, required semicolon



//class.forName()
public class Demo2 {
public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException
{
	
	
  //load the class without create objectwhich is static and then object created so the instance load 
//Class.forName("Pqr").newInstance();
	
	
	
	// while we set the connection we had load and register teh driver 
	Class.forName( "com.mysql.cj.jdbc.Driver");
	// its same DriverManager it do same because DM has static block 
	
	
   }
}
class Pqr{
	static
	{
		System.out.println("in Static ");
	}
	
	
	//instance block 
	{
		System.out.println("in instance");
	}
}
