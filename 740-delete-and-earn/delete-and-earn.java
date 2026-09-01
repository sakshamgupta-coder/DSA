class Solution {
    public int deleteAndEarn(int[] nums) {
        int freq[]=new int[10001];
        int dp[]=new int[10001];
        Arrays.fill(dp,-1);
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
        }
        if(nums.length==1)return nums[0];
        return max(freq,10001,dp);
        
    }
    private int max(int []arr,int n,int dp[]){
       dp[0]=arr[0];
       dp[1]=arr[1];
       int i;
        for(i=1;i<n;i++){
            if(i-2>=0){
            dp[i]=Math.max(arr[i]*i+dp[i-2],dp[i-1]);
            }
        }
        return dp[i-1];
    }
}