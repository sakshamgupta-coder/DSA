class Solution {
    public int minFlips(String s) {
        int n=s.length();
        int  ones=0;
        for(char c:s.toCharArray()){
            if(c=='1')ones++;
        }
        int ans=0;
        //all 0s//all 1s
        ans=Math.min(ones,n-ones);
        //exectly one'1'
         ans=Math.min(ans,Math.abs(ones-1));
         //from 1....1
         if(n>1){
            int cost=0;
            if(s.charAt(0)=='0')cost++;
            if(s.charAt(n-1)=='0')cost++;
            for(int i=1;i<n-1;i++){
                if(s.charAt(i)=='1')cost++;
            }
            ans=Math.min(ans,cost);
         }
         return ans;
    }
}