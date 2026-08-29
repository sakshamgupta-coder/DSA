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
               dp[n]=arr[n];
               dp[n-1]=Math.max(arr[n],arr[n-1]);
               for(int j=n-2;j>=i;j--){
                dp[j]=Math.max(arr[j]+dp[j+2],dp[j+1]);
               }

         return dp[i];
    }
}