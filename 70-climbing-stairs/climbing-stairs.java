class Solution {
    public int climbStairs(int n) {
        Integer[] dp=new Integer[n+1];
        return solve(0,n,dp);
    }
    private int solve(int idx,int n,Integer[]dp){
        if(idx==n) return 1;
        if(idx>n) return 0;

        if(dp[idx]!=null) return dp[idx];

        int one=solve(idx+1,n,dp);
        int two=solve(idx+2,n,dp);

        return dp[idx]=one+two;
    }
}