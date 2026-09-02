class Solution {
    public int numDecodings(String s) {
        int dp[]=new int[s.length()+1];
        return max(0,s.length(),s,dp);
    }
    private int max(int j,int n,String s,int dp[]){
        // if(i>n)return 0;
        // if(i==n)return 1;
        //  if(dp[i]!=-1)return dp[i];
        // int one=0;
        // int two=0;
        //  if(s.charAt(i)!='0'){
        //     int res=max(i+1,n,s,dp);
        //     one +=res;
        //   }
        // if(s.charAt(i)!='0'&& i+2<=n&&Integer.parseInt(s.substring(i,i+2))>=10
        // &&Integer.parseInt(s.substring(i,i+2))<=26){

        //     int res=max(i+2,n,s,dp);
        //     two+=res;
        // }
        // return dp[i]=one+two;
        dp[0]=1;

        for(int i=1;i<=n;i++){
            if(s.charAt(i-1)!='0'){
              dp[i]+=dp[i-1];
            }
            if( i>=2){
            if(Integer.parseInt(s.substring(i-2,i))>=10
                &&Integer.parseInt(s.substring(i-2,i))<=26){
                dp[i]+=dp[i-2];
                }
            }
         }
          return dp[n];
        }

}