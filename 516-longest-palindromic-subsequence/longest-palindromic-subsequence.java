class Solution {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        // for (int i = 0; i < n; i++) {
        //     Arrays.fill(dp[i], -1);
        // }

        return longestPalindromicSubSequence( n , s, dp);

    }

    private int longestPalindromicSubSequence( int n, String s, int dp[][]) {
        // if (i == j)
        //     return 1;
        // if (i > j)
        //     return 0;
        // if (dp[i][j] != -1)
        //     return dp[i][j];
        // if (s.charAt(i) == s.charAt(j)) {
        //     return dp[i][j]= 2 + longestPalindromicSubSequence(i + 1, j - 1, s, dp);
        // } else {
        //     return dp[i][j]= Math.max(longestPalindromicSubSequence(i + 1, j, s, dp),
        //             longestPalindromicSubSequence(i, j - 1, s, dp));
        // }
        for(int i=0;i<n;i++)dp[i][i]=1;

        for(int len =2;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j=len+i-1;
                if(s.charAt(i)==s.charAt(j)){
                dp[i][j]=2+dp[i+1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];

    }
}