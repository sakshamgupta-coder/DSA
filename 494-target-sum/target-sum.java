class Solution {
    public int findTargetSumWays(int[] nums, int target) {
       int n=nums.length;
       return ways(n-1,0,target,nums); 
    }
private int ways(int n,int currSum, int tar,int[] arr){
    if(n<0){
    if(tar==currSum)return 1;
    else return 0;
    }
     int add=0;
     int minus=0;
        minus=ways(n-1,currSum-arr[n],tar,arr);
        add=ways(n-1,currSum+arr[n],tar,arr);

    return minus+add;
}
}