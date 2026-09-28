class Solution {
    public int change(int amount, int[] coins){
        int n=coins.length;
        int dp[][]=new int[coins.length+1][amount+1];
        for(int[] row : dp){
         Arrays.fill(row, -1);
          }

        return waysPossible(0,n,amount,coins,dp);
    }
private int waysPossible( int i,int n, int amount,int coins[],int dp[][]){
        if(amount==0)return 1;
        if(i==n)return 0;
        if(dp[i][amount]!=-1)return dp[i][amount];
        int take=0;
       if(coins[i]<=amount){
           take=waysPossible(i,n,amount-coins[i],coins,dp);
       }
        int  not= waysPossible(i+1,n,amount,coins,dp);
        
        return  dp[i][amount]=take+not;


//     for(int i=0;i<=n;i++){
//         dp[i][0]=1;

//     }
// for(int i=1;i<=n;i++){
//     for(int j=1;j<=amount;j++){
//         if(coins[i-1]<=j){
//             dp[i][j]=dp[i][j-coins[i-1]]+dp[i-1][j];
//         }
//         else{
//             dp[i][j]=dp[i-1][j];
//         }
//     }
// }
// return dp[n][amount];
}
}