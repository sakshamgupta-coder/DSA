class Solution {
    int dp[];
    public int minCostClimbingStairs(int[] cost) {
        dp=new int [cost.length];
        Arrays.fill(dp,-1);
        return minCost(cost);
        
    }
    private int minCost(int arr[]){
        dp[arr.length-1]=arr[arr.length-1];
        dp[arr.length-2]=arr[arr.length-2];

       for(int i=arr.length-3;i>=0;i--){
         dp[i]=arr[i] +  Math.min(dp[i+1],dp[i+2]);
       }
    
        return Math.min(dp[0],dp[1]);
    }
}