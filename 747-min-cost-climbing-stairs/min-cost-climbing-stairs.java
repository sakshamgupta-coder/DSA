class Solution {
    int dp[];
    public int minCostClimbingStairs(int[] cost) {
        dp=new int [cost.length];
        Arrays.fill(dp,-1);
        return minCost(cost);
        
    }
    private int minCost(int arr[]){
        dp[0]=arr[0];
        dp[1]=arr[1];

       for(int i=2;i<arr.length;i++){
         dp[i]=arr[i] +  Math.min(dp[i-1],dp[i-2]);
       }
    
        return Math.min(dp[arr.length-1],dp[arr.length-2]);
    }
}