
/* 
 * QueensHW2.java 
 * 
 * Version: 1.0
 *     $Id$ 
 * 
 * Revisions: 1.0
 *     $Log$ 
 */

/**
 * This class solves the 8 queen problem by backtracking
 * 
 * @author Rahul Kumar Shinde
 *
 */

public class QueensHW2 {
	public static int QUEENS = 8;	//Static variable for #of queens
	int[] matrix = new int[QUEENS];
	int sol = 1;					//variable to monitor #of solutions

	/**
	 * This method prints Q if matrix[i]==1 and everything else is printed as "*".
	 */
	public void printQueens() {
		int N = matrix.length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (matrix[i] == j) {
					System.out.print("Q ");
				} else {
					System.out.print("* ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	/**
	 * This method checks for the queen if its in an attacking position.
	 * i.e. same column and diagonal positions.
	 * @param queen	This parameter is the queen index 
	 * @param column positions to be checked for placing queen 
	 * @return true if queen can be placed else false
	 */
	public boolean canPlaceQueen(int queen, int column) {
		
		for (int i = 0; i < queen; i++) {
			if (matrix[i] == column
					|| Math.abs(i - queen) == Math.abs(matrix[i] - column)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * This method decides the location of queen.
	 * @param queen	This parameter is the queen index 
	 * @param length Total number of queens.
	 */
	public void placeQueens(int queen, int length) {
		
		for (int col = 0; col < length; col++) {
			if (canPlaceQueen(queen, col)) {
				matrix[queen] = col;
				if (queen == length - 1) {		//If its the last queen, print the solution.
					System.out.println("Solution# " + sol);
					printQueens();
					sol++;		// Variable for the number of unique solutions

				} else {
					placeQueens(queen + 1, length);	//Checks for the next queen
				}
			}
		}
	}

	/**
	 * The main program.
	 *
	 * @param args command line arguments (ignored)
	 */

	public static void main(String args[]) {
		QueensHW2 q = new QueensHW2();	
		q.placeQueens(0, QUEENS);

	}
}
