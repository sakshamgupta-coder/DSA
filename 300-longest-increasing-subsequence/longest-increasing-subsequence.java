class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        int ans=0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, lis(i, nums, dp));
        }
        return ans;
    }

    private int lis(int i, int[] nums, int[] dp) {
        if(dp[i]!=-1)return dp[i];
        int max = 1;

        for (int j = i - 1; j >= 0; j--) {
            if (nums[i] > nums[j]) {
                max = Math.max(max, 1 + lis(j, nums, dp));

            }
        }
        return dp[i]= max;
    }
}
