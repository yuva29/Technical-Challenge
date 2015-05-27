/**
 * Implements StringToLong function without using inbuilt utility function
 * 
 *         Assumptions : 
 *         1. Given string has the long value in base 10. 
 *         2. Given string has only digits and '-' as prefix for negative values. 
 *         3. The range of long values supported is -2^63 to 2^63-1 (it's a java limitation). 
 *         4. If there is an overflow, that is , if the value can not be accommodated in the range of long values NumberFormatException
 *            will be thrown. 
 *         5. If the string contains characters other than 0 to 9 , NumberFormatException will be thrown. (Except for the case of
 *            first character as '-' for negative numbers)
 *         6. If provided a NULL string, an empty string or a string with only '-' character , NumberFormatException will be thrown.
 *         7. In case of errors in the input string given, the expected output is "NumberFormatException"
 *         8. For every test-case, if the expected value matches with the converted value(actual value) 
 *            then it returns 'Success', otherwise it returns 'Failure'
 *            
 */
public class StringToLong {
	public static void main(String[] args) {
		test();
	}

	/**
	 * Implements StringToLong function
	 * 
	 * @param str - String to be converted to long
	 * @return - returns the long value of the given string
	 */
	private static long stringToLong(String inputStr) {
		if (null == inputStr || 0 == inputStr.length())
			throw new NumberFormatException();
		
		int strLen = inputStr.length();
		boolean isNegative = false;
		int index = 0;
		if ('-' == inputStr.charAt(0)) {
			if (strLen == 1)
				throw new NumberFormatException();
			isNegative = true;
			index++;
		}
		long result = 0;
		long minimum =  -9223372036854775808L;
		for (; index < strLen; index++) { // for each characters in the string
			int val = inputStr.charAt(index) - '0'; // get the integer value of the character
			if (val >= 0 && val <= 9) { 
				result = result * 10 + val; 
			    if ((result < 0 && !isNegative) || (result < 0 && isNegative && result != minimum)) // overflow check
			            throw new NumberFormatException();
			} else { // anything other than integers
				throw new NumberFormatException();
			}
		}
		return isNegative ? -result : result;
	}

	/**
	 * Test function to test stringToLong
	 */
	private static void test() {
		System.out.println("Test case 1:  Input value '123' ");
		System.out.println("Expected value:  " + 123L);
		long value = stringToLong("123");
		System.out.println("Converted value:  " + value);
		if (value == 123L)
			System.out.println("Result: Success");
		else
			System.out.println("Result: Failure");
		System.out.print("\n");

		System.out.println("Test case 2:  Input value '-123' ");
		System.out.println("Expected value:  " + -123L);
		value = stringToLong("-123");
		System.out.println("Converted value:  " + value);
		if (value == -123L)
			System.out.println("Result: Success");
		else
			System.out.println("Result: Failure");
		System.out.print("\n");

		System.out.println("Test case 3:  Input value '9223372036854775807' ");
		System.out.println("Expected value:  " + 9223372036854775807L);
		value = stringToLong("9223372036854775807");
		System.out.println("Converted value:  " + value);
		if (value == 9223372036854775807L)
			System.out.println("Result: Success");
		else
			System.out.println("Result: Failure");
		System.out.print("\n");

		System.out.println("Test case 4:  Input value '-9223372036854775808' ");
		System.out.println("Expected value:  " + -9223372036854775808L);
		value = stringToLong("-9223372036854775808");
		System.out.println("Converted value:  " + value);
		if (value == -9223372036854775808L)
			System.out.println("Result: Success");
		else
			System.out.println("Result: Failure");
		System.out.print("\n");

		System.out.println("Test case 5:  Input value 'abc' ");
		try {
			System.out.println("Expected value:  " +"NumberFormatException");
			value = stringToLong("abc");
			System.out.println("Converted value: " + value);
			System.out.println("Result: Failure");
		} catch (NumberFormatException e) {
			System.out.println("Converted value: NumberFormatException");
			System.out.println("Result: Success");
		}
		System.out.print("\n");

		System.out.println("Test case 6:  Input value '13a344b12' ");
		try {
			System.out.println("Expected value:  " +"NumberFormatException");
			value = stringToLong("13a344b12");
			System.out.println("Converted value:  " + value);
			System.out.println("Result: Failure");
		} catch (NumberFormatException e) {
			System.out.println("Converted value: NumberFormatException");
			System.out.println("Result: Success");
		}
		System.out.print("\n");

		System.out.println("Test case 7:  Input value '-' ");
		try {
			System.out.println("Expected value:  " +"NumberFormatException");
			value = stringToLong("-");
			System.out.println("Converted value:  " + value);
			System.out.println("Result: Failure");
		} catch (NumberFormatException e) {
			System.out.println("Converted value: NumberFormatException");
			System.out.println("Result: Success");
		}
		System.out.print("\n");

		System.out.println("Test case 8:  Input value '9223372036854775808' ");
		try {
			System.out.println("Expected value:  " +"NumberFormatException");
			value = stringToLong("9223372036854775808");
			System.out.println("Converted value:  " + value);
			System.out.println("Result: Failure");
		} catch (NumberFormatException e) {
			System.out.println("Converted value: NumberFormatException");
			System.out.println("Result: Success");
		}
		System.out.print("\n");

		System.out.println("Test case 9:  Input value '-9223372036854775809' ");
		try {
			System.out.println("Expected value:  " +"NumberFormatException");
			value = stringToLong("-9223372036854775809");
			System.out.println("Converted value:  " + value);
			System.out.println("Result: Failure");
		} catch (NumberFormatException e) {
			System.out.println("Converted value: NumberFormatException");
			System.out.println("Result: Success");
		}
		System.out.print("\n");

		System.out.println("Test case 10:  Input value NULL ");
		try {
			System.out.println("Expected value:  " +"NumberFormatException");
			value = stringToLong(null);
			System.out.println("Converted value:  " + value);
			System.out.println("Result: Failure");
		} catch (NumberFormatException e) {
			System.out.println("Converted value: NumberFormatException");
			System.out.println("Result: Success");
		}
		System.out.print("\n");

		System.out.println("Test case 11:  Input value '' ");
		try {
			System.out.println("Expected value:  " +"NumberFormatException");
			value = stringToLong("");
			System.out.println("Converted value:  " + value);
			System.out.println("Result: Failure");
		} catch (NumberFormatException e) {
			System.out.println("Converted value: NumberFormatException");
			System.out.println("Result: Success");
		}
		System.out.print("\n");
	}
}
