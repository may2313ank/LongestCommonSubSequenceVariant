package com.mayank;

public class SequencePatternMatching {

	public static void main(String[] args) {
		String a = "axy";
		String b = "adxcpy";
		int size = lcs(a,b);
		boolean lengthCheck = false;
		if(size==a.length()) {
			lengthCheck = true;
		}
		
		System.out.println(lengthCheck);
		

	}
	 public static int lcs(String x,String y) {
		  int m = x.length();
		  int n = y.length();
		  int dp[][] = new int[m+1][n+1];
		  
		  //base condition initialized
		  for(int i=0;i<=m;i++) {
			  for(int j=0;j<=n;j++) {
				  if(i == 0 || j==0) {
					  dp[i][j]=0;
				  }
			  }
		  }
		  
		  // Fill DP table
		  for(int i=1;i<=m;i++) {
			  for(int j=1;j<=n;j++) {
				  if(x.charAt(i-1) == y.charAt(j-1)) {
					  dp[i][j] = 1 + dp[i-1][j-1];
				  }else {
					 dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
				  }
			  }
		  }
		 
		  return dp[m][n];
	 }
	

}
