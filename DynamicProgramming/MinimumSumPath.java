package DynamicProgramming;

import java.util.Scanner;

public class MinimumSumPath {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[][] input = new int[n][n];
		
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				input[i][j] = s.nextInt();
			}
		}
		s.close();
		System.out.println(minPathSum(input));
	}

	public static int minPathSum(int[][] input) {
		int n = input.length;
		int m = input[0].length;
		int[][] dp = new int[n][m];
		
		dp[0][0] = input[0][0];
		for(int i = 1;i<n;i++) {
			dp[i][0] = input[i][0] + dp[i-1][0];
		}
		
		for(int i = 1;i<m;i++) {
			dp[0][i] = input[0][i] + dp[0][i-1];
		}
		
		// Now fill the rest
		for(int i = 1;i<n;i++) {
			for(int j = 1;j<m;j++) {
				dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + input[i][j];
			}
		}
		
		// Print dp Array
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		
		return dp[n-1][m-1];
	}
	

}
