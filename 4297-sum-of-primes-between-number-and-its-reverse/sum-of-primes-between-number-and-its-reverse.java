class Solution {
    static  boolean isprime(int n){
        if(n<=1)return false;
        for(int i=2;i*i<=n;i++){
            if(n%i==0)return false;
        }
        return true;
    }
    public int sumOfPrimesInRange(int n) {
        int safe=n;
       int r=0 ;
    while(safe!=0){
       r=r*10+(safe%10);
       safe=safe/10;
    }
    if(n>r){
        int t=n;
        n=r;
        r=t;
    }
    int sum=0;
    for(int i=n;i<=r;i++){
        if(isprime(i)){
            sum+=i;
        }
    }
    return sum;
    }
}