
/* 
 * E.java 
 * 
 * Version: 1.0
 *     $Id$ 
 * 
 * Revisions: 1.0
 *     $Log$ 
 */
public class E {
	/**
	 * This method is responsible to calculate conversion 1
	 * @param d
	 * @return total
	 */
	public static double caculateEversion1(float d) {
		double total = 0; // Initialize total which stores the result
		double num = 1; // Initialize number

		// iterate till the difference is greater than 0.001
		while ((Math.E - total) > d) {
			// formula to calculate e
			total = Math.pow(((num + 1) / num), num);
			num++;		// increment num
		}
		return total;	// return total
	}

	/**
	 * This method is responsible to calculate conversion 2
	 * @param d
	 * @return total
	 */
	public static double caculateEversion2(float d) {
		// initialize total, num and lastVal
		double total = 0;
		double num = 1;
		double lastVal = 1;

		// iterate till the difference is greater than 0.001
		while ((Math.E - total) > d) {

			// formula to calculate e
			total = total + ((num * num) / (2 * (lastVal * num)));
			lastVal = lastVal * num; 	// calculate factorial

			// increase the value of k for the next summation
			num++;

		}

		return total;	// return total
	}

	/**
	 * This method is responsible to calculate conversion 3
	 * @param d
	 * @return total
	 */
	public static double caculateEversion3(float d) {
		// initialize total, num and lastVal
		double total = 1;
		double num = 1;
		double lastVal = 1;

		// iterate till the difference is greater than 0.001
		while ((Math.E - total) > d) {

			// formula to calculate
			total = total + (1 / (lastVal * num));
			lastVal = lastVal * num;
			num++;

		}

		return total;	// return total

	}

	/**
	 * The main program.
	 *
	 * @param args command line arguments (ignored)
	 */

	public static void main(String[] args) {
		float delta = 0.001f; 	//initialize delta
		System.out.println("The value of e uuing Math.E: " + Math.E);
		double e1 = caculateEversion1(delta);  // calculate e using version 1 with given delta
		double e2 = caculateEversion2(delta);  // calculate e using version 2 with given delta
		double e3 = caculateEversion3(delta);  // calculate e using version 3 with given delta

		System.out.println("The value of e using version1: "+e1);
		System.out.println("The value of e using version2: "+e2);
		System.out.println("The value of e using version3: "+e3);
		
	}

}
