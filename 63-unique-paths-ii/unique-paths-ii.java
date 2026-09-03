class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
              dp[i][j]=-1;
            }
            
        }
        if(obstacleGrid[n-1][m-1]==1)return 0;

         return uniquePaths(obstacleGrid,0,0,n,m,dp);
        
    }
    public int uniquePaths(int arr[][],int i,int j,int n,int m,int dp[][]){
        if(i>=n||j>=m)return 0;   
        if(i==n-1&&j==m-1)return 1;
        if(dp[i][j]!=-1)return dp[i][j];
         int right=0;
         int left=0;
        if(arr[i][j]!=1){

            int res1=uniquePaths(arr,i,j+1,n,m,dp);
            right+=res1;
            int res2=uniquePaths(arr,i+1,j,n,m,dp);
             left+=res2;
        }
        return dp[i][j]= right+left;
    }
}