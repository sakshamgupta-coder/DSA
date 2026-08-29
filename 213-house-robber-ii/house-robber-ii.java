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
        if(n<i) return 0;
         if(n==i) return arr[n];
         if(dp[n]!=-1)return dp[n];

         int take=arr[n]+maxRobbery(i,n-2,arr,dp);
         int notTake=maxRobbery(i,n-1,arr,dp);

         return dp[n]=Math.max(take,notTake);
    }
}