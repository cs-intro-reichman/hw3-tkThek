// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
		// Tests some of the operations
		System.out.println(plus(2, 3));   // 2 + 3
		System.out.println(minus(7, 2));  // 7 - 2
		System.out.println(minus(2, 7));  // 2 - 7
		System.out.println(times(3, 4));  // 3 * 4
		System.out.println(plus(2, times(4, 2)));  // 2 + 4 * 2
		System.out.println(pow(5, 3));      // 5^3
		System.out.println(pow(3, 5));      // 3^5
		System.out.println(div(12, 3));   // 12 / 3
		System.out.println(div(5, 5));    // 5 / 5
		System.out.println(div(25, 7));   // 25 / 7
		System.out.println(mod(25, 7));   // 25 % 7
		System.out.println(mod(120, 6));  // 120 % 6
		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
		System.out.println(sqrt(76123));
	}

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int i = 1;
		while (i <= x2) {
			x1++;
			i++;
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int i = 1;
		while (i <= x2) {
			x1--;
			i++;
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		// Write a method that takes two numbers; then:
		// Adds 1 to a 0 int until it is equal to the first number.
		// Repeats the process as many times as the magnitude of the second number.
		// Works because 3*4 = 3 + 3 + 3 + 3.
		int decomposedX1 = 0;
		for (int j = 0; j < x2; j++) {
			for (int i = 0; i < x1; i++) {
				decomposedX1++;
			}
		}
		return decomposedX1;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		// x^n = x * x * x * ... x (n times)
		// So it can be reduced to multiplying a number by itself n times.
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result = times(result, x);
		}
		return result;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		// x1/x2 = a --> a * x2 = x1
		// when (a * x2) > x1, then the integer part of x1/x2 = a - 1.
		int product = 0;
		for (int i = 1; i <= x1; i++) {
			if (times(x2, i) <= x1) {
				product = i;
			}
		}
		return product;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		// Replace the following statement with your code
		//return x1 - (x1 / x2) * x2;
		return minus(x1, times(div(x1, x2), x2));
	}

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int square = 0;
		int i = 1;
		while (true) {
			if (times(i, i) == x) {
				square = i;
				break;
			} else if (times(i, i) > x) {
				square = i-1;
				break;
			}
			i++;
		}
		return square;
	}
}