class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][]=new int[coins.length][amount+1];
        // for(int i=0;i<coins.length;i++){
        // Arrays.fill(dp[i],-1);   
        // } 
        return totalCoinsNeeded(coins.length,coins,amount,dp);
    }
    private int totalCoinsNeeded(int n,int arr[],int amount,int [][]dp){
    //     if(amt==0)return 0;
    //     if(i==n)return -1;
    //     if(dp[i][amt]!=-1)return dp[i][amt];
    //     int take=-1;
    //    if(arr[i]<=amt){
    //        int res=totalCoinsNeeded(i,n,arr,amt-arr[i],dp);
    //        if(res!=-1)take=1+res;
    //    }
    //     int  not= totalCoinsNeeded(i+1,n,arr,amt,dp);
    //     if(take == -1 && not==-1)return dp[i][amt]= -1;
    //     if(take==-1)return  dp[i][amt]= not;
    //     if(not==-1) return  dp[i][amt]= take;
    //     return  dp[i][amt]=Math.min(take,not);
    
     for(int j=1;j<=amount;j++){
        if(j%arr[0]==0)dp[0][j]=j/arr[0];
        else dp[0][j]=1000000000;
     }
     for(int i=1;i<n;i++){
        for(int j=1;j<=amount;j++){
            int notTake=dp[i-1][j];
            int take=1000000000;
            if(arr[i]<=j){
                take=1+dp[i][j-arr[i]];
            }
            dp[i][j]=Math.min(take,notTake);
        }
     }
     return (dp[n-1][amount]>=1000000000)?-1:dp[n-1][amount];

    }
}