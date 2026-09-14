class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        return minSum(n-1,m-1,grid,dp);
        
    }
    private int minSum(int n,int m,int [][]arr,int dp[][]){
        if(n<0||m<0)return Integer.MAX_VALUE;
        if(0==n&&0==m)return arr[n][m];
        if(dp[n][m]!=-1)return dp[n][m];
         
         int up=minSum(n-1,m,arr,dp);
         int left=minSum(n,m-1,arr,dp);

         return  dp[n][m]=arr[n][m]+Math.min(left,up);

    }
}