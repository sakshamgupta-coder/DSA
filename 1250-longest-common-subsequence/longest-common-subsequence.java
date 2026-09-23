class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int dp[][]=new int[n+1][m+1];
        // for(int i=0;i<n;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        return maxSub(n,m,s1,s2,dp);
        
    }
    private int maxSub(int n,int m,String s1,String s2,int [][]dp){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
        // if(n<0||m<0)return 0;
        // if(dp[n][m]!=-1)return dp[n][m];

        // if(s1.charAt(n)==s2.charAt(m)){
        //     return dp[n][m]=1+maxSub(n-1,m-1,s1,s2,dp);
        // }
        // else{
        //     return dp[n][m]=Math.max(maxSub(n-1,m,s1,s2,dp),maxSub(n,m-1,s1,s2,dp));
        // }
    }
}