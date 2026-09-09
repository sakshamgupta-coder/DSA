class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n=dungeon.length;
        int m=dungeon[0].length;
        int dp[][]=new int[n][m];
        

        return min(n,m,dungeon,dp);
        
    }
    private  int min(int n,int m,int arr[][],int dp[][]){
        // if(i==n-1&&j==m-1)return arr[i][j]>0?1:-arr[i][j]+1;
        // if(i>=n||j>=m)return Integer.MAX_VALUE;        
        // if(dp[i][j]!=-1)return dp[i][j];

        // int r=min(i,j+1,n,m,arr,dp);
        // int d=min(i+1,j,n,m,arr,dp);
        // int res=Math.min(r,d)-arr[i][j];

        // return  dp[i][j]=Math.max(1,res);
        if(arr[n-1][m-1]>0)dp[n-1][m-1]=1;
        else
        dp[n-1][m-1]=-arr[n-1][m-1]+1;

        for (int j=m-2;j>=0;j--){
         dp[n-1][j]=(arr[n-1][j]-dp[n-1][j+1]>=0)?1:dp[n-1][j+1]-arr[n-1][j];
          }
         for (int j=n-2;j>=0;j--){
         dp[j][m-1]=(arr[j][m-1]-dp[j+1][m-1]>=0)?1:dp[j+1][m-1]-arr[j][m-1];
          }
          for(int i=n-2;i>=0;i--){
            for(int j=m-2;j>=0;j--){
               dp[i][j]=(arr[i][j]>0)? Math.max(1,Math.min(dp[i+1][j],dp[i][j+1])-arr[i][j]):Math.min(dp[i+1][j],dp[i][j+1])-arr[i][j];
            }
          }
          return dp[0][0];
    }
}