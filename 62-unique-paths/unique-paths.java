class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
              dp[i][j]=-1;
            }    
        }
         return uniquePaths(0,0,n,m,dp);
        
    }
    public int uniquePaths(int i,int j,int n,int m,int dp[][]){
        if(i>=m||j>=n)return 0;   
        if(i==m-1&&j==n-1)return 1;
        if(dp[i][j]!=-1)return dp[i][j];
         int right=uniquePaths(i,j+1,n,m,dp);
         int left=uniquePaths(i+1,j,n,m,dp);
        return dp[i][j]= right+left;
    }
}
