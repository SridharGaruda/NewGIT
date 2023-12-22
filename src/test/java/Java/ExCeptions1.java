package Java;

public class ExCeptions1 {

	public static void NestedTryCatch() {
		try {

			try {
				int data = 100 / 0;
				System.out.println(data);
			} catch (ArithmeticException A) {System.out.println("caught the 1st error");}

			try {
				int data1 [] = new int [5];
				System.out.println(data1[6]);
			} catch (ArrayIndexOutOfBoundsException A) {System.out.println("caught the 2nd error");}
						
		} catch (Exception e) {
			System.out.println("Normal flow");
		}
		System.out.println("Last statement");
	}
	
	
	public static void Finally()
	{
		try {
			int I = 100;
			System.out.println(I);	
		} catch (ArithmeticException e) {
			System.out.println(e);
		}
		finally {
			System.out.println("Yesss.... finally");
		}
	}

	public static void main(String[] args) {
		
		ExCeptions1.NestedTryCatch();
		ExCeptions1.Finally();

		// outer try block
		try {
			// inner try block 1
			try {
				System.out.println("going to divide by 0");
				int b = 39 / 0;
			}
			// catch block of inner try block 1
			catch (ArithmeticException e) {
				System.out.println(e);
			}

			// inner try block 2
			try {
				int a[] = new int[5];

				// assigning the value out of array bounds
				a[6] = 4;
			}

//			 catch block of inner try block 2
			catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(e);
			}

			System.out.println("other statement");
		}
		// catch block of outer try block
		catch (Exception e) {
			System.out.println("handled the exception (outer catch)");
		}

		System.out.println("normal flow..");
	}
}
