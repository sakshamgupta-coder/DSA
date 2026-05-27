class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        int []leftRow=new int[n];
        int []upperDigo=new int[2*n-1];
        int []lowerDigo=new int[2*n-1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        solve(0, n, board,leftRow,upperDigo,lowerDigo, ans);
        return ans;
    }
  public static void solve(int col,int n,char[][] board,int []leftRow,int []upperDigo,int []lowerDigo, List<List<String>> ans){
    if(col==n){
        List<String> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            res.add(new String(board[i]));
        }
        ans.add(new ArrayList<>(res));
        return;
    }
    for(int row=0;row<n;row++){
        if(leftRow[row]==0&&upperDigo[n-1+col-row]==0&&lowerDigo[row+col]==0){
            board[row][col]='Q';
            leftRow[row]=1;
            upperDigo[n-1+col-row]=1;
            lowerDigo[row+col]=1;
            solve(col+1,n,board,leftRow,upperDigo,lowerDigo,ans);
          board[row][col]='.';  
           leftRow[row]=0;
            upperDigo[n-1+col-row]=0;
            lowerDigo[row+col]=0;      
        }
    }
   }
}
