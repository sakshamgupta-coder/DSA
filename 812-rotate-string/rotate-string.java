class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length())return false;
        int n=s.length();
        for(int i=0;i<n;i++){
           
            if(s.equals(goal))return true;
            else{
                s=s.substring(1)+s.charAt(0);
                
            }
        }
        return false;
        
    }
}