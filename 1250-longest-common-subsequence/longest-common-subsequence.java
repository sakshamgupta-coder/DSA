class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return maxSub(n-1,m-1,s1,s2,dp);
        
    }
    private int maxSub(int n,int m,String s1,String s2,int [][]dp){
        if(n<0||m<0)return 0;
        if(dp[n][m]!=-1)return dp[n][m];

        if(s1.charAt(n)==s2.charAt(m)){
            return dp[n][m]=1+maxSub(n-1,m-1,s1,s2,dp);
        }
        else{
            return dp[n][m]=Math.max(maxSub(n-1,m,s1,s2,dp),maxSub(n,m-1,s1,s2,dp));
        }
    }
}