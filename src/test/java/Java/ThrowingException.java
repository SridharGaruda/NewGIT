package Java;

import java.util.Scanner;

public class ThrowingException {

	public static void age(int Age)
	{
		if (Age < 18)
		{
			throw new ArithmeticException("Person is not eligable for vote");
		}
		else
		{
			System.out.println("Person is eligible to vote");
		}
	}
	
	public static void main(String[] args) {
		
		
		
    Scanner SC = new Scanner(System.in);
    ThrowingException.age(SC.nextInt());
	}
}
