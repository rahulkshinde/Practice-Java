/* 
 * StackExpr.java 
 * 
 * Version: 1.0
 *     $Id$ 
 * 
 * Revisions: 1.0
 *     $Log$ 
 */
package assignment;
import java.util.Arrays;
import java.util.Scanner;

/** 
 * This class evaluates the input following expression
 * ( (  1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) ) and displays
 * the calculated result of the expresion.
 * 
 * @author      Rahul Kumar Shinde 
 *
 */
public class StackExpr {
	
	public int top = -1;
	String[] stackArr; 
	private int stackSize;
	
	/**
	 * Constructor.
	 * @param size size of the stack
 	 */
	StackExpr(int size){
		stackSize = size;
		stackArr = new String[size];
		
	}
	
	/**
	 * Given the stack input operand/operator/braces, pushes the
	 * values into the stack array.
	 * @param input		input expression 
	 */
	
	public void push(String input){
		if(top + 1 < stackSize ){
		top++;
		stackArr[top] = input;
		} else System.out.println("Stack Full");
	}
	
	/**
	 * Given the implemented stack array , pops out the
	 * values into the stack array and decrements the top index.
	 *  
	 */

	public String pop(){
	
		String topStr = stackArr[top];
	      stackArr[top] = null;
	      top--;
	      return topStr;     
			
	}
	
	/**
	 * Given the implemented stack array , displays the
	 * values into the stack array.
	 */
	
	public void displayStack(){
			System.out.println(Arrays.toString(stackArr));
		}
		
	/**
	 * This method calculates the expression
	 * @param a 	second operand from stack
	 * @param b		first operand from stack
	 * @param op	operator from stack
	 * @return ans calculation result
	 */
	public float calculate(float a, float b, char op){
		float ans = 0;
		if(op == '+') ans = a+b;
		else if(op == '-') ans = a-b;
		else if(op == '*') ans = a*b;
		return ans;
	}
	
	/**
	 * This method serially parses and processes the input expression
	 * and calls the appropriate methods
	 * @param s String expression
	 */
	public void evalExpr(String s){
		for (int i=0; i<s.length(); i++){
			
			// avoid spaces in the expression
			if(s.charAt(i) == ' ') continue;
			
			// 
			else if(s.charAt(i) == ')'){
				//displayStack();
				String a = pop();
				String operator = pop();
				String b = pop();
				pop();   //move the top by -1 and removes the "("
				float ans = calculate(Float.parseFloat(b), Float.parseFloat(a), operator.charAt(0));
	            push(Float.toString(ans)); // push the answer to the stack
	            //System.out.println(b + " "+ operator + " "+ a +" = " + ans);
	            //displayStack();
	           
	            
			}else push(Character.toString(s.charAt(i)));
			
		}
	}
	
	/**
	   * The main program.
	   *
	   * @param    args    command line arguments (ignored)
	   */

	public static void main(String[] args) {
	    String exprToEvalaute;
	    Scanner input = new Scanner(System.in);
	    System.out.println("Enter the given expression: ");
	    exprToEvalaute = input.nextLine();
	    input.close();
	    StackExpr newStack = new StackExpr(exprToEvalaute.length());
		
		newStack.evalExpr(exprToEvalaute);
		System.out.println(newStack.pop());
	    
	}
	
}