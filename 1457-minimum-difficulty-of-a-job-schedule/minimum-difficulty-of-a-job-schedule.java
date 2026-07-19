class Solution {
    int t[][]=new int[301][11];
   
    public int solve(int []arr,int n,int idx,int day){
   //base case if only one one day remaining then do all the task
   if(day==1){
    int maxD=arr[idx];
    for(int i=idx;i<n;i++){
        maxD=Math.max(maxD,arr[i]);
    }
    return maxD;
   }
   if(t[idx][day]!=-1){
    return t[idx][day];
   }
   int maxD=arr[idx];
   int finalResult=Integer.MAX_VALUE;
   //try one by one all possibility
   for(int i=idx;i<=n-day;i++){
    maxD=Math.max(maxD,arr[i]);
    int result=maxD+solve(arr,n,i+1,day-1);
    finalResult=Math.min(finalResult,result);
   }
return  t[idx][day]=finalResult;

    }
    public int minDifficulty(int[] jd, int d) {
        int n=jd.length;
        if(n<d)return -1;
        for (int[] row : t) {
    Arrays.fill(row, -1);
  }
        return solve(jd,n,0,d);
    }
}