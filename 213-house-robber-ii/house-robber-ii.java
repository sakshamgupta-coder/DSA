class Solution {
    public int rob(int[] nums) {
        int dp1[]=new int[nums.length];
        Arrays.fill(dp1,-1);
         int dp2[]=new int[nums.length];
          Arrays.fill(dp2,-1);
       if(nums.length==1)return nums[0];
       if(nums.length==2)return Math.max(nums[0],nums[1]);

        return Math.max(maxRobbery(0,nums.length-2,nums,dp1),
                         maxRobbery(1,nums.length-1,nums,dp2));
    }
    private int maxRobbery( int i,int n,int arr[],int dp[]){
               dp[i]=arr[i];
               dp[i+1]=Math.max(arr[i],arr[i+1]);
               for(int j=i+2;j<=n;j++){
                dp[j]=Math.max(arr[j]+dp[j-2],dp[j-1]);
               }

         return dp[n];
    }
}