package edu.uscb.csci470sp23;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Write import statements (note: we'll need to update pom.xml to include slf4j-simple as a dependency)

/**
 * This class contains methods for testing the arithmetic utility
 * methods defined in the CalculationUtil class.
 * 
 * @author gmquick@email.uscb.edu
 * @version 3/11/2023
 */
public class CalculationUtilTest {

	Logger logger = LoggerFactory.getLogger(CalculationUtilTest.class);
	
	@Test
	public void testAdd() {

		double value1 = 10;
		double value2 = 25;
		double expectedResult = 35;
		double tolerance = 0.00005;

		double testResult = CalculationUtil.add(value1, value2);

		logger.info("testAdd expected: " + expectedResult + ", actual: " + testResult);

		assertEquals(expectedResult, testResult, tolerance);
		
	} // end method testAdd

	@Test
	public void testSubtract() {

		double value1 = 25;
		double value2 = 10;
		double expectedResult = 15.0;
		double tolerance = 0.00005;

		double testResult = CalculationUtil.subtract(value1, value2);
		
		logger.info("testSubtract expected: " + expectedResult + ", actual: " + testResult);

		assertEquals(expectedResult, testResult, tolerance);
		
	} // end test method testSubtract

	@Test
	public void testMultiply() {
		
		double value1 = 25;
		double value2 = 10;
		double expectedResult = 250.0;
		double tolerance = 0.00005;

		double testResult = CalculationUtil.multiply(value1, value2);
		
		logger.info("testMultiply expected: " + expectedResult + ", actual: " + testResult);

		assertEquals(expectedResult, testResult, tolerance);
		
	} // end test method testMultiply

	@Test
	public void testDivide() {
		
		double value1 = 25;
		double value2 = 10;
		double expectedResult = 2.5;
		double tolerance = 0.00005;

		double testResult = CalculationUtil.divide(value1, value2);
		
		logger.info("testDivide expected: " + expectedResult + ", actual: " + testResult);

		assertEquals(expectedResult, testResult, tolerance);

	} // end test method testDivide

	@Test
	public void testLongDivision() {
		
		int dividend = 25;
		int divisor = 10;
		String expectedResult = "2R5";

		String testResult = CalculationUtil.longDivision(divisor, dividend);
		
		logger.info("testLongDivision expected: " + expectedResult + ", actual: " + testResult);

		assertTrue(expectedResult.equals(testResult));
		
	} // end test method testLongDivision
	
} // end class CalculationUtilTest
