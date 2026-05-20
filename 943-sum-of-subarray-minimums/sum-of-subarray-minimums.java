class Solution {
    static public int[] prevSmaller(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) ans[i] = -1;
            else ans[i] = st.peek();
            st.push(i);
        }
        return ans;
    }
    static int[] nextSmallerEle(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) ans[i] = n;
            else ans[i] = st.peek();
            st.push(i);
        }
        return ans;
    }
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int []NSL=prevSmaller(arr);
        int []NSR=nextSmallerEle(arr);
        long sum=0;
        int mod=1000000007;
        for(int i=0;i<n;i++){
            long ls=i-NSL[i];
            long rs=NSR[i]-i;
            long totalWays=ls*rs;
            sum = (sum + (totalWays * arr[i]) % mod) % mod;
        }
        return (int)sum;
        
    }
}