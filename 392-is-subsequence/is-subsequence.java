class Solution {
    public boolean isSubsequence(String s, String t) {
        return(subsequence(s,0,t,0));
    }

    public boolean subsequence(String s,int i,String t,int j){
        if(s.length()==0)return true;
        if(i==s.length())return true;
        if(j>t.length()-1)return false;
      if(s.charAt(i)==t.charAt(j)){
        return subsequence(s,i+1,t,j+1);
      }
      return subsequence(s,i,t,j+1);
    }
}