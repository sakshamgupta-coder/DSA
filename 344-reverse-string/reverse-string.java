class Solution {
    public void reverseString(char[] s) { 
       reverse( s,0,s.length-1);  
    }
    void reverse(char []s,int i,int j){
        if(i>=j)return;
         char a=s[i];
         s[i]=s[j];
         s[j]=a;
        reverse(s,i+1,j-1);
    }
}