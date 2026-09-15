class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i:nums)
        sum+=i;

        if(sum%2!=0)return false;
        int target=sum/2;
        Boolean dp[][]=new Boolean[n][target+1];
     return check(nums,n-1,target,dp);
        
    }
    private boolean check(int arr[],int n,int target,Boolean dp[][]){
        if(target==0)return true;
        if(n<0||target<0)return false;
        if(dp[n][target]!=null)return dp[n][target];
        
        boolean  take=check(arr,n-1,target-arr[n],dp);
        boolean  not=check(arr,n-1,target,dp);
        return  dp[n][target]=take||not;
    }
}