package com.gavin;

class Test4 {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int i = 0; i < n ; i ++) {
            for (int j = 0 ; j < n; j ++) {
                int l = i + j;

                if (i == 0) {
                    dp [i][j] = false;
                } else if (i == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
                }

                if (dp[i][j] && (i + 1)> ans.length()) {
                    ans = s.substring(i, i + j + 1);
                }
            }
        }
        return ans;

    }
}
