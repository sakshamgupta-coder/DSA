class Solution {
    int dp[];
    public int rob(int[] nums) {
         dp=new int [nums.length+1];
        return maxProfit(nums,nums.length);
        
    }
    private int  maxProfit(int arr[],int n){
       if(n==0)return 0;
       if(n==1) return arr[0];
       dp[n-1]=arr[n-1];
       dp[n-2]=Math.max(arr[n-1],arr[n-2]);

       for(int i=n-3;i>=0;i--){
        dp[i]=Math.max(arr[i]+dp[i+2],dp[i+1]);
       }
        return dp[0];
    } 
}