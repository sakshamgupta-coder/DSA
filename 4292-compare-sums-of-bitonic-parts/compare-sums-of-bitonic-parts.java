class Solution {
    public int compareBitonicSums(int[] nums) {
        int i=0;
        long sumA=0;
        while(nums[i]<nums[i+1]){
            sumA+=nums[i];
            i++;
        }
        i++;
        long sumB=0;
        while(i<nums.length){
            sumB+=nums[i];
            i++;
        }
        if(sumA==sumB)return -1;
        return sumA<sumB ? 1:0;
    }
}