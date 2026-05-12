class Solution {
    public static int dp[]=new int[31];
    static{Arrays.fill(dp,-1);}
    public int fib(int n) {
        if(n<=1)return n;
        int f,s;
        if(dp[n-1]!=-1) f=dp[n-1];
        else  f=dp[n-1]=fib(n-1);
          if(dp[n-2]!=-1) s=dp[n-2];
        else s=dp[n-2]=fib(n-2);  
        
        return dp[n]=f+s;
    }
}