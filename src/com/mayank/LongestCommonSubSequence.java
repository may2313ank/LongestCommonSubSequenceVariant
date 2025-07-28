package com.mayank;

public class LongestCommonSubSequence {

  public static void main(String[] args) {
	String x = "abcdgh";
	String y = "abedfhr";
	
	System.out.println(lcs(x,y));
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
	 
	  // Now construct the LCS string by backtracking
      int i = m, j = n;
      StringBuilder lcsStr = new StringBuilder();

      while (i > 0 && j > 0) {
          if (x.charAt(i - 1) == y.charAt(j - 1)) {
              lcsStr.append(x.charAt(i - 1));
              i--;
              j--;
          } else if (dp[i - 1][j] > dp[i][j - 1]) {
              i--;
          } else {
              j--;
          }
      }

      lcsStr.reverse(); // reverse because we added from the end
      System.out.println("LCS string: " + lcsStr.toString());
	  
	  return dp[m][n];
  }
}
