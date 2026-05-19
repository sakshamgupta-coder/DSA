class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
        int n=s.length();
        int left=0;
        int currCnt=0,maxCnt=0;
        for(int right=0;right<n;right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                currCnt--;
                left++;
            }
            set.add(s.charAt(right));
            currCnt++;
            maxCnt=Math.max(maxCnt,currCnt);

        }
       return maxCnt;
    }
}