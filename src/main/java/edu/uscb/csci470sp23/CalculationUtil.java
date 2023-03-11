package edu.uscb.csci470sp23;

/**
 * The class defines arithmetic utility methods used by
 * the CalculationatorBuilder class (a static inner class
 * defined within the Calculation class).
 * 
 * @author gmquick@email.uscb.edu
 * @version 3/11/2023
 */
public class CalculationUtil {

	/*
	 * Protect constructor as this is a static-only class
	 * that cannot be instantiated.
	 */
	
	protected CalculationUtil() {}
	
	/**
	 * Utility method for adding two numbers together. This is
	 * a commutative operation, the the order in which the
	 * operands are specified will not affect the result.
	 * 
	 * @param num1
	 * @param num2
	 * @return the sum num1 + num2
	 */
	public static double add(double num1, double num2) {
		
		//return 35.0; /*mock return value*/
		
		return num1 + num2;
		
	} // end method add

	/**
	 * Utility method for subtracting one number from another.
	 * This is NOT a commutative operation; the second number
	 * is subtracted from the first number.
	 * 
	 * @param num1
	 * @param num2
	 * @return the difference, num2 - num1
	 */
	public static double subtract(double num1, double num2) {
		
		//return 0.0; /* mock return value */
		
		return num1 - num2;
		
	} // end method subtract
	
	/**
	 * Utility method for multiplying two numbers together.
	 * This is a commutative operation, so the order in which
	 * the operands are specified will not affect the result.
	 * 
	 * @param num1
	 * @param num2
	 * @return the product num1 * num2
	 */
	public static double multiply(double num1, double num2) {
		
		// return 0.0; /* mock return value */
		
		return num1 * num2;
		
	} // end method multiply
	
	/**
	 * Utility method for dividing one floating-point number by another.
	 * This is NOT a commutative operation; the first number is divided
	 * by the second number.
	 * 
	 * @param num1
	 * @param num2
	 * @return the quotient, num1 / num2
	 */
	public static double divide(double num1, double num2) {
		
		//return 0.0; /* mock return value */
		
		return num1 / num2;
		
	} // end method divide

	/**
	 * Utility method for performing long division of one integer
	 * by another to produce a String result "qRr", where
	 * "q" represents the quotient (computed using integer division)
	 * and "r" represents that remainder (computed using the modulo
	 * operation, %). Note to obtain the intended result, the order
	 * of the parameters should be divisor first, dividend second. This
	 * will more accurately reflect how long division would appear if
	 * computed "on paper".
	 * 
	 * @param divisor
	 * @param dividend
	 * @return the long division result of dividend / divisor
	 */
	public static String longDivision(int divisor, int dividend) {
		
		//return ""; /* mock return value */
		
		int q = dividend / divisor;
		int r = dividend % divisor;
		
		return q + "R" + r;
		
	} // end method longDivision
	
} // end class CalculationUtil

