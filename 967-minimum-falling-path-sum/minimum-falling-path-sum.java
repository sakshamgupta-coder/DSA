class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int dp[][]=new int[n][n];
       
        return min(n,matrix,dp);
        
    }
     private int min(int n,int arr[][],int dp[][]){
      for(int i=0;i<n;i++){
          dp[0][i]=arr[0][i];
         }
         
         for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
               dp[i][j] = dp[i-1][j] + arr[i][j];
                if(j-1 >= 0)
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + arr[i][j]);
                if(j+1 < n)
                 dp[i][j] = Math.min(dp[i][j], dp[i-1][j+1] + arr[i][j]);
            }
         }
         int ans=Integer.MAX_VALUE;
         for(int i=0;i<n;i++){
          ans=Math.min(ans,dp[n-1][i]);
         }
         return ans;

     }
}