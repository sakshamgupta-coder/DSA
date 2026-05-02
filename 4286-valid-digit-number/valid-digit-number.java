class Solution {
    public boolean validDigit(int n, int x) {
     int f = n;
        while(f >= 10){
            f/=10;        
            }
           if(f==x)return false;
        
       while(n > 0){
        if(n%10==x){
             return true;
       }
       n/=10;
       }
        return false;
    
    }
}