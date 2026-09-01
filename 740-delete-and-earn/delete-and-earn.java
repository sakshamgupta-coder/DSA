class Solution {
    public int deleteAndEarn(int[] nums) {
        int freq[]=new int[10001];
        int dp[]=new int[10001];
        Arrays.fill(dp,-1);
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
        }
        if(nums.length==1)return nums[0];
        return max(freq,0,10001,dp);
        
    }
    private int max(int []arr,int i,int n,int dp[]){
        if(i==n-1)return arr[i];
        if(i>=n)return 0;

        if(dp[i]!=-1){  return dp[i];}
        int take=arr[i]*i+max(arr,i+2,n,dp);
        int notTake=max(arr,i+1,n,dp);
        return dp[i]=Math.max(take,notTake);
    }
}