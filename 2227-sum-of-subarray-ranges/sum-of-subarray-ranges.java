class Solution {
public static int[] previousSmaller(int []nums){
    int n=nums.length;
    Stack<Integer> st=new Stack<>();
    int []ans=new int[n];
    for(int i=0;i<n;i++){
       while(!st.isEmpty()&& nums[st.peek()]>nums[i])st.pop();
       ans[i]=st.isEmpty()?-1:st.peek();
       st.push(i);
    }
    return ans;
}

public static int[] previousGreater(int []nums){
    int n=nums.length;
    Stack<Integer> st=new Stack<>();
    int []ans=new int[n];
    for(int i=0;i<n;i++){
       while(!st.isEmpty()&& nums[st.peek()]<nums[i])st.pop();
       ans[i]=st.isEmpty()?-1:st.peek();
       st.push(i);
    }
    return ans;
}
public static int[] nextSmaller(int []nums){
    int n=nums.length;
    Stack<Integer> st=new Stack<>();
    int []ans=new int[n];
    for(int i=n-1;i>=0;i--){
       while(!st.isEmpty()&& nums[st.peek()]>=nums[i])st.pop();
       ans[i]=st.isEmpty()?n:st.peek();
       st.push(i);
    }
    return ans;
}
public static int[] nextGreater(int []nums){
    int n=nums.length;
    Stack<Integer> st=new Stack<>();
    int []ans=new int[n];
    for(int i=n-1;i>=0;i--){
       while(!st.isEmpty()&& nums[st.peek()]<=nums[i])st.pop();
       ans[i]=st.isEmpty()?n:st.peek();
       st.push(i);
    }
    return ans;
}
public  long sumOfMinimums(int []nums){
    int n=nums.length;
    int [] prevSmaller=previousSmaller(nums);
    int [] nextSmaller=nextSmaller(nums);
    long sum=0;
    for(int i=0;i<n;i++){
        long l=i-prevSmaller[i];
        long r=nextSmaller[i]-i;
        sum+=(long)nums[i]*l*r;
    }
    return sum;
}
public  long sumOfMaximums(int []nums){
    int n=nums.length;
    int [] prevSmaller=previousGreater(nums);
    int [] nextSmaller=nextGreater(nums);
    long sum=0;
    for(int i=0;i<n;i++){
        long l=i-prevSmaller[i];
        long r=nextSmaller[i]-i;
        sum+=(long)nums[i]*l*r;
    }
    return sum;
}

    public long subArrayRanges(int[] nums) {
        long maxSum=sumOfMaximums(nums);
        long minSum=sumOfMinimums(nums);
        return maxSum-minSum;
    }

}