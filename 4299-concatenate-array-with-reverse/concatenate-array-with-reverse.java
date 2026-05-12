class Solution {
    public int[] concatWithReverse(int[] nums) {
        int n=nums.length;
       int arr[]=new int[n*2];
       int i;
       for( i=0;i<n;i++){
        arr[i]=nums[i];
       } 

       for( int j=n-1;j>=0;j--){
        arr[i]=nums[j];
        i++;
       }
       return arr;
    }
}