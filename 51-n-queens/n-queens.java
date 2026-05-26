class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        solve(0, n, board, ans);
        return ans;
    }

    public static boolean isSafe(int row, int col, char[][] board, int n) {
        int r = row;
        int c = col;
        while (r >= 0 && c >= 0) {
            if (board[r][c] == 'Q')
                return false;
            r--;
            c--;
        }
        c = col;
        r = row;
        while (c >= 0) {
            if (board[r][c] == 'Q')
                return false;
            c--;

        }
        c = col;
        r = row;
        while (r < n && c >= 0) {
            if (board[r][c] == 'Q')
                return false;
            r++;
            c--;
        }
        return true;
    }

  public static void solve(int col,int n,char[][] board,List<List<String>> ans){
    if(col==n){
        List<String> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            res.add(new String(board[i]));
        }
        ans.add(new ArrayList<>(res));
        return;
    }
    for(int row=0;row<n;row++){
        if(isSafe(row,col,board,n)){
            board[row][col]='Q';
            solve(col+1,n,board,ans);
          board[row][col]='.';        
        }
    }
   }
}
