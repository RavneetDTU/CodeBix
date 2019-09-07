package DynamicProgramming;

import java.util.Scanner;

public class UniquePathWithObstacle {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();
		int[][] input = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				input[i][j] = s.nextInt();
			}
		}
		
		s.close();
		System.out.println(uniquePathsWithObstacles(input));
	}

	public static int uniquePathsWithObstacles(int[][] input) {
		int m = input.length;
		int n = input[0].length;
		int[][] dp = new int[m][n];
		
		for(int i = 0;i<m;i++) {
			if(input[i][0] == 0) {
				dp[i][0] = 1;
			}
			
		}
		
		for(int i = 0;i<n;i++) {
			if(input[0][i] == 0) {
				dp[0][i] = 1;
			}
		}
		
		for(int i = 1;i<m;i++) {
			for(int j = 1;j<n;j++) {
				if(input[i][j] == 0) {
					dp[i][j] = dp[i-1][j] + dp[i][j-1];	
				}
			}
		}
		
		return dp[m-1][n-1];
	}

}
