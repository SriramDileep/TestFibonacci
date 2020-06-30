package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Enter the number");
			int number = scan.nextInt();
			long fibonacci = fibonacci(number);
			System.out.println("Fibonacci of " + number + " number is " + fibonacci);
		}
	}

	public static long fibonacci(int num) {
		if (num < 3)
			return 1;

		// Map to store the previous results
		Map<Integer, Long> computedValues = new HashMap<Integer, Long>();

		computedValues.put(1, 1L);
		computedValues.put(2, 1L);

		return fibonacci(num, computedValues);
	}

	private static long fibonacci(int n, Map<Integer, Long> computedValues) {
		if (computedValues.containsKey(n))
			return computedValues.get(n);

		computedValues.put(n - 1, fibonacci(n - 1, computedValues));
		computedValues.put(n - 2, fibonacci(n - 2, computedValues));

		long newValue = computedValues.get(n - 1) + computedValues.get(n - 2);
		computedValues.put(n, newValue);
		return newValue;
	}
}