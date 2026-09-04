class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
              dp[i][j]=-1;
            }    
        }
         return uniquePaths(n,m,dp);
        
    }
    public int uniquePaths(int n,int m,int dp[][]){
        for(int i=m-1;i>=0;i--){
            dp[i][n-1]=1;
        }
        for(int i=n-1;i>=0;i--){
            dp[m-1][i]=1;
        }
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                dp[i][j]=dp[i+1][j]+dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}
