package Java;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ExCeptions {

	public static void numberFormatException() {
		try {
			String N = "hi";
			System.out.println(Integer.parseInt(N));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// an example to resolve the exception in a catch block.
	public static void resolve() {
		int i = 50;
		int j = 0;
		int data;
		try {
			data = i / j; // may throw exception
		}
		// handling the exception
		catch (Exception e) {
			// resolving the exception in catch block
			System.out.println(i / (j + 5)+" resolving error");
		}
	}

	/*
	 * multi-catch block - In this example, try block contains two exceptions. But
	 * at a time only one exception occurs and its corresponding catch block is
	 * executed.
	 */

	public static void main1() {

		try {
			int a[] = new int[5];

			System.out.println(a[10]);
		} catch (ArithmeticException e) {
			System.out.println("Arithmetic Exception occurs");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBounds Exception occurs");
		} catch (Exception e) {
			System.out.println("Parent Exception occurs");
		}
		System.out.println("Multi catch blocks");
	}

	public static void main(String[] args) {

		ExCeptions.main1();
		ExCeptions.numberFormatException();
		ExCeptions.resolve();

		try {
			int data = 100 / 0;
			System.out.println(data);
		} catch (ArithmeticException e) {
			System.out.println(e);
		}

		try {
			String s = null;
			System.out.println(s.length());
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
		System.out.println("Rest of the codes");
	}
}
