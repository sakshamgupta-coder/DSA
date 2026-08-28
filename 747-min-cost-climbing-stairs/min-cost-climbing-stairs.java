class Solution {
    int dp[];
    public int minCostClimbingStairs(int[] cost) {
        dp=new int [cost.length];
        Arrays.fill(dp,-1);
        return Math.min(minCost(cost.length-1,cost),
        minCost(cost.length-2,cost));
        
    }
    private int minCost(int n,int arr[]){

        if(n<0)return 0;
        if(dp[n]!=-1)return dp[n];
        return  dp[n]=arr[n] +  Math.min(minCost(n-1,arr),minCost(n-2,arr));
    }
}