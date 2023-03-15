package edu.uscb.csci470sp23;

/**
 * Defines an object that contains all of the information needed to store
 * a Calculation object for later use, including the two operands, the
 * arithmetic operation, and the computed result. The creation of this object
 * is handled by a STATIC INNER class called CalculationBuilder, which is part
 * of the Builder design pattern. 
 * 
 * @author gmquick@email.uscb.edu
 * @version 03/15/2023
 */
public class Calculation {

	private final double num1;
	private final double num2;
	private final String operation;
	private final String result;
		
	/* 
	 * By using a private constructor, we prevent other (outside) classes
	 * from instantiating a Calculation object DIRECTLY, but because we have
	 * defined CalculationBuilder as a static INNER class (see below), then
	 * that class still has access to this constructor. 
	 */
	private Calculation(CalculationBuilder builder) {
		this.num1 = builder.num1;
		this.num2 = builder.num2;
		this.operation = builder.operation;
		this.result = builder.result;
	} // end builder-pattern constructor

	/*
	 * While a true JavaBean or Bean has the usual pattern of private fields,
	 * at least one constructor, and public setters/getters, we WON'T include
	 * the setters here -- that way, the Calculation object is immutable
	 */
	/**
	 * @return the num1
	 */
	public double getNum1() {
		return num1;
	}

	/**
	 * @return the num2
	 */
	public double getNum2() {
		return num2;
	}

	/**
	 * @return the operation
	 */
	public String getOperation() {
		return operation;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}
	
	/*
	 * We haven't created our CalculatorServlet class just yet, but just 
	 * as a heads-up, we will use the following statement to "build" our
	 * Calculation object when it needs to be instantiated by the
	 * CalculatorServlet class
	 * 
	 * Calculation calculation = 
	 * 		new Calculation.CalculationBuilder(
	 * 			firstNumber, secondNumber, operation)
	 *  	.result()
	 *  	.build();
	 *  
	 * By following this pattern, we gain a number of benefits:
	 * 
	 * 1) We don't have to call any methods from the Calculation 
	 *    constructor (which can be dangerous if the object is not fully 
	 *    initialized)
	 *    
	 * 2) We don't have to rely on an outside class to handle the details
	 *    of computing a given calculation result (it's all encapsulated
	 *    right here... see below)
	 *    
	 * 3) Also -- by making this INNER class STATIC, we simplify the syntax so 
	 *    that only a single statement is needed for the client to build
	 *    the Calculation (in this case, the client is the CalculatorServlet) 
	 */
	public static class CalculationBuilder 
	{
		private final double num1;
		private final double num2;
		private final String operation;
		private String result; // can't be final; needs to be "built" later
		
		/*
		 * This constructor DOES need to be public since it will be called
		 * by CalculatorServlet...
		 */
		public CalculationBuilder(double num1, double num2, String operation) {
			this.num1 = num1;
			this.num2 = num2;
			this.operation = operation;
		} // end CalculationBuilder constructor
		
		/*
		 * ...and by computing the result here, rather than in a separate
		 * servlet class, this helps to COMPLETELY ENCAPSULATE the details
		 * of how the Calculation object is computed :-)
		 */
		public CalculationBuilder result() {
			switch( this.operation ) {
			case "add":
				this.result = String.format("%s", CalculationUtil.add(num1, num2));
				break;
			case "subtract":
				this.result = String.format("%s", CalculationUtil.subtract(num1, num2));
				break;
			case "multiply":
				this.result = String.format("%s", CalculationUtil.multiply(num1, num2));
				break;	
			case "divide":
				this.result = String.format("%s", CalculationUtil.divide(num1, num2));
				break;
			case "longDivision":
				this.result = String.format("%s", CalculationUtil.longDivision((int)num1, (int)num2));
				break;
			default:
				break;
			} // end switch
			return this;
		} // end CalculationBuilder method result
		
		/*
		 * This method is what is responsible for instantiating the 
		 * Calculation object by passing a reference to the corresponding
		 * CalculationBuider object, which contains all the information needed
		 * for the Calculation to be fully initialized (including the result 
		 * itself!)
		 */
		public Calculation build() {
			Calculation calculation = new Calculation(this);
			// See NOTE below**
			return calculation;
		} // end CalculationBuilder method build
		
		/*
		 * **NOTE: You might choose to do some validation in the build() method
		 * to make sure the object obeys whatever practical constraints we might
		 * have to prevent the application from functioning abnormally, but 
		 * we'll be coding our validation steps in the CalculatorServlet class
		 */
		
	} // end inner static class CalculationBuilder
	
} // end class Calculation