class Solution {
    static int dp[][];
    public int findTargetSumWays(int[] nums, int target) {
       int n=nums.length;
       int sum=0;
       for(int a:nums){
        sum+=a;
       }
       dp=new int[n+1][sum+1];
       for(int i=0;i<=n;i++){
        Arrays.fill(dp[i],-1);
       }
       return ways(n-1,0,target,nums); 
    }
private int ways(int n,int currSum, int tar,int[] arr){
    if(n<0){
    if(tar==currSum)return 1;
    else return 0;
    }
    if(currSum>=0&&dp[n][currSum]!=-1)return dp[n][currSum];
     int add=0;
     int minus=0;
        minus=ways(n-1,currSum-arr[n],tar,arr);
        add=ways(n-1,currSum+arr[n],tar,arr);
        if(currSum>=0)
        dp[n][currSum]= minus+add;
    return  minus+add;
        }
}