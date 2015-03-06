

/* 
 * Palindrome.java 
 * 
 * Version: 1.0
 *     $Id$ 
 * 
 * Revisions: 1.0
 *     $Log$ 
 */
import java.util.Scanner;
import java.io.File;

/**
 * This class is responsible for checking all the palindrome in a file.
 * 
 * @author Rahul Kumar Shinde
 *
 */
public class Palindrome {

	/**
	 * This method is responsible for checking if the passed string is a
	 * palindrome or not.
	 * 
	 * @param s
	 *            String passed to check
	 */
	public static void checkPalindrome(String s) {
		int first = 0; 									// start of the string
		int last = s.length() - 1; 						// end of the string
		while (last > first) { 							// till both the pointers cross 
														// each other
			if (s.charAt(first) == s.charAt(last)) { 	// if equal characters
				first++; 								// increment first
				last--; 								// decrement last
			} else {
				return; 								// if not equal return
			}

		}
		System.out.println(s); // prints all the possbile palindromes
	}

	/**
	 * The main program.
	 *
	 * @param args command line arguments (ignored)
	 */

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("palindrome_1.txt"));
			while (sc.hasNext()) {
				String line = sc.nextLine();
				line = line.replaceAll("[:,'\\s]*", "");       // regular expression to remove
															   // :,',spaces
				line = line.toLowerCase();					   // convert the string in lowercase
				
				// start from the first character in the line
				for (int i = 0; i < line.length(); i++) {		
					for (int j = i + 2; j < line.length(); j++) {  // start from the i+2th character 
																   // of the line
						if (line.charAt(i) == line.charAt(j)) {	   // check if equal

							// pass the substring to the method
							checkPalindrome(line.substring(i, j + 1));	
						}
					}
				}
			}
			sc.close();												//close the scanner
		} catch (Exception e) {
			System.err.println("Something went wrong!");
		}
	}
}