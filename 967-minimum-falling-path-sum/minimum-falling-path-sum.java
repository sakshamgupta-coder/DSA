class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=10000;
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            ans=Math.min(ans,min(n-1,n-i-1,matrix,dp));
        }
        return ans;
        
    }
     private int min(int n,int m,int arr[][],int dp[][]){
      if(n<0)return Integer.MAX_VALUE;
      if(m<0||m>arr.length)return Integer.MAX_VALUE;
      if(n==0) return arr[n][m];
      if(dp[n][m]!=10000)return dp[n][m];

      int ans=arr[n][m]+min(n-1,m,arr,dp);
      if(m-1>=0)
      ans=Math.min(ans,arr[n][m]+min(n-1,m-1,arr,dp));

      if(m+1<arr.length)
      ans=Math.min(ans,arr[n][m]+min(n-1,m+1,arr,dp));

      return dp[n][m]=ans;

     }
}