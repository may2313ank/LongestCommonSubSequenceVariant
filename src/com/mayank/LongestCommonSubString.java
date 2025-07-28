package com.mayank;

public class LongestCommonSubString {

	public static void main(String[] args) {
		String  x = "abcdgh";
		String y = "abedfhr";
		
		System.out.println(lcs(x,y));

	}
	
	public static int lcs(String x,String y) {
		int m = x.length();
		int n = y.length();
		int maxLength = Integer.MIN_VALUE;
		int dp[][] = new int[m+1][n+1];
		int endIndex = 0; // to track where substring ends in x
		
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0 || j==0) {
					dp[i][j] = 0;
				}
			}
		}
		
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(x.charAt(i-1) == y.charAt(j-1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
					 maxLength = Math.max(maxLength, dp[i][j]);
//					 if(dp[i][j] > maxLength) {
//		                    maxLength = dp[i][j];
//		                    endIndex = i;
//		                }
				}else {
					dp[i][j] = 0;
				}
			}
				
			}
		
		
//		return x.substring(endIndex - maxLength, endIndex);
		return maxLength;
	}

}
