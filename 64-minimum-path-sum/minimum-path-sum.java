class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        return minSum(0,0,n-1,m-1,grid,dp);
        
    }
    private int minSum(int i,int j,int n,int m,int [][]arr,int dp[][]){
        if(i>n||j>m)return Integer.MAX_VALUE;
        if(i==n&&j==m)return arr[i][j];
        if(dp[i][j]!=-1)return dp[i][j];
         
         int right=minSum(i,j+1,n,m,arr,dp);
         int down=minSum(i+1,j,n,m,arr,dp);

         return  dp[i][j]=arr[i][j]+Math.min(right,down);

    }
}