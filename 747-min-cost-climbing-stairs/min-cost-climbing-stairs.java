// class Solution {
//     int dp[];
//     public int minCostClimbingStairs(int[] cost) {
//         dp=new int [cost.length];
//         Arrays.fill(dp,-1);
//         return Math.min(minCost(cost.length-1,cost),
//         minCost(cost.length-2,cost));
        
//     }
//     private int minCost(int n,int arr[]){

//         if(n<0)return 0;
//         if(dp[n]!=-1)return dp[n];
//         return  dp[n]=arr[n] +  Math.min(minCost(n-1,arr),minCost(n-2,arr));
//     }
// }
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int p1=cost[0];
        int p2=cost[1];
        for(int i=2;i<cost.length;i++){
            int temp=cost[i]+Math.min(p1,p2);
            p1=p2;
            p2=temp;
        }
        return Math.min(p1,p2);
      
       
    }
}