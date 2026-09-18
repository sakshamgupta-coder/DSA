class Solution {
    public int lastStoneWeightII(int[] arr) {
        int n=arr.length;
        if(n==1)return arr[0];
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        int  dp[][]=new int [n+1][sum/2+1];
       return minSum(n,sum,0,arr,dp); 
        
      }
       private int  minSum(int n,int sum,int curr,int arr[],int dp[][]){
    //   if(sum==curr) return 0;
    //   if(n==0)return Math.abs(sum-2*curr);
    //  if(dp[n][curr]!=-1)return dp[n][curr]; 
    //   int take=minSum(n-1,sum,curr+arr[n],arr,dp);
    //   int not=minSum(n-1,sum,curr,arr,dp);
    //   return dp[n][curr]=Math.min(take,not);
        for(int i=1;i<=n;i++){
            for(int j=0;j<=sum/2;j++){
                if (arr[i-1]<=j){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-arr[i-1]]+arr[i-1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
   return sum-2*dp[n][sum/2];
        
    }
   }
