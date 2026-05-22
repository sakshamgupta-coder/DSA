class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && k > 0 && st.peek() - '0' > num.charAt(i) - '0') {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }

        while (k > 0&&!st.isEmpty()) {
            st.pop();
            k--;
        }

        if (st.isEmpty())
            return "0";
        while (!st.isEmpty()) {
            ans.append(st.pop());

        }
        while(ans.length()>0&& ans.charAt(ans.length()-1)=='0'){
            ans.deleteCharAt(ans.length()-1);
        }
        if (ans.length()==0){
            return "0";
        }
        ans.reverse();
        return ans.toString();
    }
}