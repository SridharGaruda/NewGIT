package Java;

import java.util.Scanner;

class UserDefinedException  {
	public static void main(String[] args) {
		UserDefinedException obj = new UserDefinedException();
		obj.p();
		
		
		Scanner sc = new Scanner(System.in);
		String Person = sc.next();
		if (Person.equals("Manu")) {
			System.out.println("Welcome");
		}
		else {			
		
		try {
			throw new Exception("Wrong person, Access denied");
		} catch (Exception e) {

			System.out.println("caught the exception");
			System.out.println(e.getMessage());			
		}

		}
	}
	
	// Java Exception Propagation -  If an exception is not caught in a method it drops down to its called method this continues till it reaches the last method 
	void m()
	{
	  int i = 50/0;
	}
	
	void n()
	{
		m();
	}
	
	void p()
	{
		try{
			n();
		}
		catch (Exception e) {
         System.out.println("handle exception");
		}
	}
}
