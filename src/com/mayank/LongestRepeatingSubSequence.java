package com.mayank;

public class LongestRepeatingSubSequence {

	public static void main(String[] args) {
		String str = "AABEBCDD";
		System.out.println("Print the repeaating subsequence "+lcs(str));
		System.out.println("Length: "+lcs(str).length());
	}
	
	 public static String lcs(String x) {
		  int n = x.length();

		  int dp[][] = new int[n+1][n+1];
		
		  // Fill the DP table
		  for(int i=1;i<=n;i++) {
			  for(int j=1;j<=n;j++) {
				  if((x.charAt(i-1) == x.charAt(j-1)) && i != j) {
					  dp[i][j] = 1 + dp[i-1][j-1];
				  }else {
					 dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
				  }
			  }
		  }
		  
		// Step 2: Reconstruct the sequence
	        int i = n, j = n;
	        StringBuilder sb = new StringBuilder();

	        while (i > 0 && j > 0) {
	            if (x.charAt(i - 1) == x.charAt(j - 1) && i != j) {
	                sb.append(x.charAt(i - 1));
	                i--;
	                j--;
	            } else if (dp[i - 1][j] > dp[i][j - 1]) {
	                i--;
	            } else {
	                j--;
	            }
	        }

	        return sb.reverse().toString();
	 }
	}