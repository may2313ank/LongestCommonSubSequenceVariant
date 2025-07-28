package com.mayank;

public class LongestPalendromicSubsequence {

	public static void main(String[] args) {
		String a = "agbcba";
		String b = reverse(a); 
		System.out.println("Longest Palendromic: "+lcs(a,b));
	}
	
	
	public static String reverse(String a) {
	    return new StringBuilder(a).reverse().toString();
	}
	
	public static int lcs(String a, String b) {
		int m = a.length();
		int n = b.length();
		int dp[][]= new int[m+1][n+1];
		
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(a.charAt(i-1) == b.charAt(j-1)) {
					dp[i][j]=1+dp[i-1][j-1];
				}else {
					dp[i][j]= Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		return dp[m][n];
	}

}
