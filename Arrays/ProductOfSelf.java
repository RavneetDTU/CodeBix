package Arrays;

import java.util.Scanner;

public class ProductOfSelf {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = s.nextInt();
		}
		s.close();
		int[] output = productExceptSelf(input);
		// Printing output
		for (int i = 0; i < n; i++) {
			System.out.print(output[i] + " ");
		}
	}

	public static int[] productExceptSelf(int[] input) {
		int[] output = new int[input.length];
		int[] left = new int[input.length];
		int[] right = new int[input.length];

		// Filling the left
		left[0] = 1;
		for (int i = 1; i < left.length; i++) {
			left[i] = left[i - 1] * input[i - 1];
		}

		// Filling the Right
		right[input.length - 1] = 1;
		for (int i = input.length - 2; i >= 0; i--) {
			right[i] = right[i + 1] * input[i + 1];
		}

		for (int i = 0; i < input.length; i++) {
			output[i] = left[i] * right[i];
		}

		return output;
	}

}
