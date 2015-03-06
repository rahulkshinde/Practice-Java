
/* 
 * Hanoi.java 
 * 
 * Version: 1.0
 *     $Id$ 
 * 
 * Revisions: 1.0
 *     $Log$ 
 */

/**
 * This class solves the tower of hanoi problem with problem while printing each
 * move
 * @author Rahul Shinde
 */
public class Hanoi {
	static int disc = 3;

	// Initialize tower array
	static int[] tower0 = new int[disc];
	static int[] tower1 = new int[disc];
	static int[] tower2 = new int[disc];

	/**
	 * This recursive method is responsible for shifting the one disks at a
	 * time, disk can be moved if its the uppermost and no large disk can be
	 * placed over small disk.
	 * 
	 * @param n disc number
	 * @param poleStart start pole
	 * @param poleOver auxiliary pole
	 * @param poleEnd end pole
	 */
	public static void move(int n, String poleStart, String poleOver,
			String poleEnd) {
		if (n == 1)
			// prints disks from the start pole to the end pole
			printTower(1, poleStart, poleEnd);
		else {
			// move n-1 discs recursively from the poleStart to the poleOver
			move(n - 1, poleStart, poleEnd, poleOver);

			// print the discs from the start pole to the end pole
			printTower(n, poleStart, poleEnd);

			// move the discs recursively from the poleOver to the poleEnd
			move(n - 1, poleOver, poleStart, poleEnd);
		}
	}

	/**
	 * This method is responsible for printing the tower
	 * 
	 * @param n disc number
	 * @param poleStart start pole
	 * @param poleOver auxiliary pole
	 * @param poleEnd end pole
	 */
	static void printTower(int currentDisc, String poleStart, String poleEnd) {
		int lastPos;

		// Prints tower 0
		if (poleStart == "0") {
			System.out.println("Move disk " + currentDisc + " from pole "
					+ poleStart + " to pole " + poleEnd);
			System.out.println();

			// check for the top most disc on the tower
			lastPos = getFromTower(tower0);
			// remove the top disc
			tower0[lastPos] = 0;

			if (poleEnd == "1") {
				lastPos = getToTower(tower1);
				// move currentDisc on the tower
				tower1[lastPos] = currentDisc;
				printScreen();
			} else if (poleEnd == "2") {
				lastPos = getToTower(tower2);
				// move current disc on the tower
				tower2[lastPos] = currentDisc;
				printScreen();
			}
		}
		// Prints tower 1
		else if (poleStart == "1") {
			System.out.println("Move disk " + currentDisc + " from pole "
					+ poleStart + " to pole " + poleEnd);
			System.out.println();
			lastPos = getFromTower(tower1);
			// remove the top most disc
			tower1[lastPos] = 0;

			if (poleEnd == "0") {
				lastPos = getToTower(tower0);
				// move the current disc on the tower
				tower0[lastPos] = currentDisc;
				printScreen();
			} else if (poleEnd == "2") {
				lastPos = getToTower(tower2);
				// move the current disc on the tower
				tower2[lastPos] = currentDisc;
				printScreen();
			}
		}

		// Prints tower 2
		else if (poleStart == "2") {
			System.out.println("Move disk " + currentDisc + " from pole "
					+ poleStart + " to pole " + poleEnd);
			System.out.println();
			lastPos = getFromTower(tower2);
			// remove the top most disc
			tower2[lastPos] = 0;
			if (poleEnd == "0") {
				lastPos = getToTower(tower0);
				// move the current disc on the tower
				tower0[lastPos] = currentDisc;
				printScreen();
			} else if (poleEnd == "1") {
				lastPos = getToTower(tower1);
				// move the current disc on the tower
				tower1[lastPos] = currentDisc;
				printScreen();
			}
		}
	}

	/**
	 * Print the towers for each move.
	 *
	 */
	static void printScreen() {
		for (int currentDisc = disc - 1; currentDisc >= 0; currentDisc--) {
			System.out.println("" + tower0[currentDisc] + " "
					+ tower1[currentDisc] + " " + tower2[currentDisc]);
		}
		System.out.println("-----");
		System.out.println("0 1 2");
		System.out.println();
	}

	/**
	 * This method gets the top most disk of the tower
	 * 
	 * @param tower[] the tower number
	 * @return tower.length-count position of top disc
	 */ 
	static int getFromTower(int[] tower) {
		int count = 1;

		// iterate the pole of tower for the top disc
		for (int position = tower.length - 1; position >= 0; position--) {
			// iterate till a disc is found
			if (tower[position] == 0) {
				count++;
			} else
				return tower.length - count;
		}
		return 0;
	}

	/**
	 * This method gets the top available vacant place of the tower
	 * 
	 * @param tower[] the tower number
	 * @return (tower.length-count)+1 empty position on the tower
	 */
	static int getToTower(int[] tower) {
		int count = 1;

		// iterate the tower looking for available position
		for (int position = tower.length - 1; position >= 0; position--) {
			// iterate till a disc is found on the tower
			if (tower[position] == 0) {
				count++;
			}
			// return the position above the disc
		}
		return (tower.length - count) + 1;
	}

	/**
	 * The main program
	 * 
	 * @param args
	 */

	public static void main(String[] args) {

		// store the initial number of discs on tower 0
		for (int pos = disc - 1; pos >= 0; pos--) {
			tower0[pos] = disc - pos;
		}

		// Print the initial tower positions
		for (int pos = disc - 1; pos >= 0; pos--) {
			System.out.println("" + tower0[pos] + " " + tower1[pos] + " "
					+ tower2[pos]);
		}
		System.out.println("-----");
		System.out.println("0 1 2");
		System.out.println();

		// move n discs from tower 0 to 2 using tower1
		move(disc, "0", "1", "2");
	}

}
