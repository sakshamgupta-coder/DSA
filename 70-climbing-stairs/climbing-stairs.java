class Solution {
    public int climbStairs(int n) {
        Integer[] dp=new Integer[n+1];
        return solve(n,dp);
    }
    private int solve(int n,Integer[]dp){
        dp[n]= 1;
        dp[n-1]=1;
        for(int j=n-2;j>=0;j--){
        if(dp[j]!=null) return dp[j];
         dp[j]=dp[j+1]+dp[j+2];
        }

    
        return dp[0];
    }
}