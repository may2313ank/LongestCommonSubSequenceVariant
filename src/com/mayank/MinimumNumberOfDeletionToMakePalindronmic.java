package com.mayank;

public class MinimumNumberOfDeletionToMakePalindronmic {

	public static void main(String[] args) {
		String s="agbcba";
		
		int lpsLength = longestPalindromicSubsequence(s);
		int deletion = s.length()-lpsLength;
		System.out.println("Min. No of Deletion: "+deletion);
		
	}
	public static int longestPalindromicSubsequence(String str) {
		
		int n = str.length();
		String reverse = new StringBuilder(str).reverse().toString();
		
		int dp[][] = new int [n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(str.charAt(i-1) == reverse.charAt(j-1)) {
					dp[i][j] = 1+ dp[i-1][j-1];
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		return dp[n][n];
	}

}
