class Solution {
    public int climbStairs(int n) {
        Integer[] dp=new Integer[n+1];
        return solve(0,n,dp);
    }
    private int solve( int i,int n,Integer[]dp){
        dp[0]= 1;
        dp[1]=1;
        for(int j=2;j<=n;j++){
        if(dp[j]!=null) return dp[j];
         dp[j]=dp[j-1]+dp[j-2];
        }

    
        return dp[n];
    }
}