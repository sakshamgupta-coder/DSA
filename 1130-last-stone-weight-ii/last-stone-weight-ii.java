class Solution {
    public int lastStoneWeightII(int[] arr) {
        int n=arr.length;
        if(n==1)return arr[0];
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        int  dp[][]=new int [n+1][sum+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
       return minSum(n-1,sum,0,arr,dp); 
        
      }
       private int  minSum(int n,int sum,int curr,int arr[],int dp[][]){
      if(sum==curr) return 0;
      if(n==0)return Math.abs(sum-2*curr);
      
     if(dp[n][curr]!=-1)return dp[n][curr];
      
      int take=minSum(n-1,sum,curr+arr[n],arr,dp);
      int not=minSum(n-1,sum,curr,arr,dp);
      
      
      return dp[n][curr]=Math.min(take,not);
        
    }
   }
