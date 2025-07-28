package com.mayank;

public class MinimumNoOfInsertionDeletion {

	public static void main(String[] args) {
		String x = "heap";
		String y = "pea";
		int m = x.length();
		int n = y.length();

		int lcsLength = lcs(x,y,m,n);
		int deletion = m - lcsLength;
		int insertion = n - lcsLength;

		System.out.println("Insertions: " + insertion + ", Deletions: " + deletion);

	}
	public static int lcs(String x,String y,int m,int n){

		int dp[][] = new int[m+1][n+1];

		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(x.charAt(i-1) == y.charAt(j-1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
				}else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}

		return dp[m][n];
	}
}
