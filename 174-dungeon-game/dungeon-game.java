class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n=dungeon.length;
        int m=dungeon[0].length;
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }

        return min(0,0,n,m,dungeon,dp);
        
    }
    private  int min(int i,int j,int n,int m,int arr[][],int dp[][]){
        if(i==n-1&&j==m-1)return arr[i][j]>0?1:-arr[i][j]+1;
        if(i>=n||j>=m)return Integer.MAX_VALUE;

        
        if(dp[i][j]!=-1)return dp[i][j];

        int r=min(i,j+1,n,m,arr,dp);
        int d=min(i+1,j,n,m,arr,dp);
        int res=Math.min(r,d)-arr[i][j];

        return  dp[i][j]=Math.max(1,res);
    }
}