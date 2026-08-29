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
    private int maxRobbery(int i,int n,int arr[],int dp[]){
        if(i>n) return 0;
         if(i==n) return arr[i];
         if(dp[i]!=-1)return dp[i];

         int take=arr[i]+maxRobbery(i+2,n,arr,dp);
         int notTake=maxRobbery(i+1,n,arr,dp);

         return dp[i]=Math.max(take,notTake);
    }
}