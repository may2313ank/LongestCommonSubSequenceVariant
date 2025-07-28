package com.mayank;

public class ShortestCommonSupersequencePrint {

	 public static void main(String[] args) {
	        String str1 = "abac";
	        String str2 = "cab";

	        String scs = shortestCommonSupersequence(str1, str2);
	        System.out.println("Shortest Common Supersequence: " + scs);
	    }

	    public static String shortestCommonSupersequence(String X, String Y) {
	        int m = X.length();
	        int n = Y.length();

	        // Step 1: Build LCS table
	        int[][] dp = new int[m + 1][n + 1];

	        for (int i = 1; i <= m; i++) {
	            for (int j = 1; j <= n; j++) {
	                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
	                    dp[i][j] = 1 + dp[i - 1][j - 1];
	                } else {
	                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
	                }
	            }
	        }

	        // Step 2: Backtrack to build SCS
	        int i = m, j = n;
	        StringBuilder sb = new StringBuilder();

	        while (i > 0 && j > 0) {
	            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
	                sb.append(X.charAt(i - 1));
	                i--;
	                j--;
	            } else if (dp[i - 1][j] > dp[i][j - 1]) {
	                sb.append(X.charAt(i - 1));
	                i--;
	            } else {
	                sb.append(Y.charAt(j - 1));
	                j--;
	            }
	        }

	        // Add remaining characters
	        while (i > 0) {
	            sb.append(X.charAt(i - 1));
	            i--;
	        }
	        while (j > 0) {
	            sb.append(Y.charAt(j - 1));
	            j--;
	        }

	        return sb.reverse().toString();
	    }
	}