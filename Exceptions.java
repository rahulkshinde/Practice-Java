
/* 
 * Exceptions.java 
 * 
 * Version: 1.0
 *     $Id$ 
 * 
 * Revisions: 1.0
 *     $Log$ 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class is throws five exceptions.
 * 
 * @author Rahul Kumar Shinde
 *
 */
@SuppressWarnings("serial")
public class Exceptions extends Exception {

	/**
	 * This method tries to read a non-existent file, Precondition: The file
	 * named "123asd" should not be present.
	 */
	public static void fileException() {
		try {
			Scanner sc = new Scanner(new File("123asd.txt"));
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("Exception1 thrown: " + e);
			e.printStackTrace();
		}
	}

	/**
	 * This method invokes array out of bound exception.
	 */
	public static void arrayException() {
		try {
			int[] temp = { 1, 2, 3 };
			System.out.println("Fourth element is: " + temp[3]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Exception2 thrown: " + e);
			e.printStackTrace();
		}
	}

	/**
	 * This method invokes an arithmetic exception
	 */
	public static void calcException() {
		try {
			int a = 10 / 0;
			System.out.println(a);
		} catch (ArithmeticException e) {
			System.out.println("Exception3 thrown: " + e);
			e.printStackTrace();
		}
	}

	/**
	 * This method invokes null pointer exception
	 */
	public static void nullException() {
		try {
			String[] arr = new String[10];
			int len = arr[0].length();
			System.out.println(len);
		} catch (NullPointerException e) {
			System.out.println("Exception4 thrown: " + e);
			e.printStackTrace();
		}
	}

	/**
	 * This method invokes a custom exception
	 */
	public static void customException() {
		try {

			throw new Exceptions();

		} catch (Exceptions e) {
			System.out.println("Custom Exception thrown");
			e.printStackTrace();
		}

	}

	/**
	 * The main program.
	 *
	 * @param args command line arguments (ignored)
	 */

	public static void main(String[] args) {
		fileException();
		arrayException();
		calcException();
		nullException();
		customException();

	}
}
