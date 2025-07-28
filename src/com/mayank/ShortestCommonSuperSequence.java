package com.mayank;

public class ShortestCommonSuperSequence {

	public static void main(String[] args) {
		String x = "AGGTAB";
		String y = "GXTXAYB";
		int m = x.length();
		int n = y.length();
				
		int count = m+n-lcs(x,y,m,n);
		System.out.println(count);
				
	}
	
	public static int lcs(String x,String y,int m,int n) {
		int dp[][] = new int[m+1][n+1];
		
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0 || j==0) {
					dp[i][j] = 0;
				}
			}
		}
		
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(x.charAt(i-1) ==y.charAt(j-1)) {
					dp[i][j] = 1 +dp[i-1][j-1];
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
			
		}
		
		return dp[m][n];
	}

}
