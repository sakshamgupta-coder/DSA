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
       return minSum(0,n,sum,0,arr,dp); 
        
      }
       private int  minSum(int i,int n,int sum,int curr,int arr[],int dp[][]){
      if(sum==curr) return 0;
      if(i==n-1)return Math.abs(sum-2*curr);
      
     if(dp[i][curr]!=-1)return dp[i][curr];
      
      int take=minSum(i+1,n,sum,curr+arr[i],arr,dp);
      int not=minSum(i+1,n,sum,curr,arr,dp);
      
      
      return dp[i][curr]=Math.min(take,not);
        
    }
   }