
/* 
 * WordCount.java 
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
 * This class is responsible for reading content of a file and
 * displaying required information from the file. 
 * 
 * @author Rahul Kumar Shinde
 *
 */
public class WordCount {
	/**
	 * This method takes the scanner file input and calculates:
	 * 1. Number of lines
	 * 2. Number of words
	 * 3. Number of characters
	 * 4. Printing words and their occurrences in descending order
	 * @param file Scanner object as parameter
	 */
	public static void calculate(Scanner file) {
		int lines = 0;					// variable to maintain the # of lines
		int words = 0;  				// variable to maintain the # of lines
		int chars = 0;					// variable to maintain the # of chars
		
		String wordOccurence[] = new String[5000]; 	// Array for word occurrences
		int occurence[] = new int[5000]; 			// Array for counting occurrences

		while (file.hasNext()) {

			String line = file.nextLine();			// one line per iteration
			lines++;								
			String[] wordsArr = line.split("\\s+"); // take the words into array, split by space
			words += wordsArr.length;
			for (int i = 0; i < wordsArr.length; i++) { //iterate through the word
				chars += wordsArr[i].length();			
				for (int j = 0; j < wordOccurence.length; j++) { 
					if (wordOccurence[j] == null) {			// check if true
						wordOccurence[j] = wordsArr[i];		// place the word
						(occurence[j])++;					// increment at the index by 1
						break;								// break and go to previous loop
					} else if (wordOccurence[j].equals(wordsArr[i])) {
						(occurence[j])++;					//if equal, increment by 1
						break;
					}
				}

			}

		}
		
		// get the number of elements that has words
		int k = 0;
		int totalWords = 0;
		while (wordOccurence[k] != null) {
			totalWords++;
			k++;
		}
		// Bubble sort iterations till the occurrences and wordOccurences are sorted.
		for (int i = 0; i < (totalWords - 1); i++) {
			for (int j = 0; j < totalWords - i - 1; j++) {
				if (occurence[j] < occurence[j + 1]) {
					int temp = occurence[j];                   //swapping the occurrences
					String tempWord = wordOccurence[j];		   //swapping the wordOccurences
					occurence[j] = occurence[j + 1];
					wordOccurence[j] = wordOccurence[j + 1];
					occurence[j + 1] = temp;
					wordOccurence[j + 1] = tempWord;
				}
			}
		}
		// print the # of lines, words and characters
		System.out.println("The number of lines in the file are: " + lines);
		System.out.println("The number of words in the file are: " + words);
		System.out
				.println("The number of characters in the file are: " + chars);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Words and #Occurences:");
		System.out.println("++++++++++++++++++++++");
		// Print the sorted array for wordOccurence and occurence till it has values.
		int m = 0;
		while (wordOccurence[m] != null) {
			System.out.println(wordOccurence[m] + " " + occurence[m]);
			m++;
		}

	}
	/**
	 * The main program.
	 *
	 * @param args command line arguments (ignored)
	 */
	public static void main(String[] args) throws FileNotFoundException {

		Scanner file = new Scanner(new File("File.txt")); //Pass the file to the scanner
		calculate(file);	 //call to the method with scanner object as a parameter
		file.close();		 // scanner closed
	}

}
