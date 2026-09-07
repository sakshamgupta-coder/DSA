class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int dp[][]=new int[101][101];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-100000;
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            ans=Math.min(ans,minimum(0,i,n-1,m-1,matrix,dp));
        }
        return ans;     
    }
    private int minimum(int i,int j,int n,int m,int arr[][],int dp[][]){
        if(i > n) return Integer.MAX_VALUE;
        if(j < 0 || j > m) return Integer.MAX_VALUE;

         if(i == n) return arr[i][j];
        if(dp[i][j]!=-100000)return dp[i][j];
          int take=arr[i][j]+minimum(i+1,j,n,m,arr,dp);
          if(j-1>=0){
            int res=minimum(i+1,j-1,n,m,arr,dp);
            take=Math.min(take,arr[i][j]+res);
          }
          if(j+1<=n)
           take=Math.min(take,arr[i][j]+minimum(i+1,j+1,n,m,arr,dp));

          return dp[i][j]=take;

    }
}