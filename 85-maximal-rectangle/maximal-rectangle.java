class Solution {
    public static  int histrogram(int arr[]){
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int maxArea=0;
        for(int i=0;i<=n;i++){
            int currHei=(i==n)?0:arr[i];
            while(!st.isEmpty()&&currHei<arr[st.peek()]){
             int height=arr[st.pop()];
             int width;
             if(st.isEmpty()){
                width=i;}
                else {
                      width=i-st.peek()-1;
                }
             maxArea=Math.max(maxArea,width*height);

            }
            st.push(i);
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        int  n=matrix.length,m=matrix[0].length;
        int preMat[][]=new int[n][m];
        int maxArea=0;
        for(int j=0;j<m;j++){
            int sum=0;
            for(int i=0;i<n;i++){
                if(matrix[i][j]=='1')
                sum+=1;
                else sum=0;
                preMat[i][j]=sum;
            }
            
        }

        for(int i=0;i<n;i++){
                maxArea=Math.max(maxArea,histrogram(preMat[i]));
                
         }
         return maxArea;
    }
}