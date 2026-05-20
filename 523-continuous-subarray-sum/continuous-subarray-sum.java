class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remIdx = new HashMap<>();
        int sum = 0;
        remIdx.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = sum % k;
            if (remIdx.containsKey(remainder)) {
                if (i - remIdx.get(remainder)>1) {
                    return true;
                }
            } else {
                remIdx.put(remainder, i);
            }

        }
        return false;
    }
}