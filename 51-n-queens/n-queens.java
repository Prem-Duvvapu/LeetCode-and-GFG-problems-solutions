class Solution {
    private boolean isValid(char[][] curr,int row,int col,int n)
    {
        //row check
        int r=row;
        int c=col;
        while (c>=0)
        {
            if (curr[r][c]=='Q')
                return false;
            c--;
        }
        
        //upper-left diagonal
        r=row;
        c=col;
        while (r>=0 && c>=0)
        {
            if (curr[r][c]=='Q')
                return false;
            r--;
            c--;
        }

        //lower-left diagonal
        r=row;
        c=col;
        while (r<n && c>=0)
        {
            if (curr[r][c]=='Q')
                return false;
            r++;
            c--;
        }

        return true;
    }

    private void solve(int col,int n,char[][] curr,boolean[] rc,boolean[] udc,boolean[] ldc,List<List<String>> res)
    {
        if (col==n)
        {
            List<String> l=new ArrayList<>();
            for (char[] arr: curr)
                l.add(new String(arr));
            
            res.add(l);
            return;
        }

        for (int row=0;row<n;row++) //row
        {
            if (!rc[row] && !udc[row+col] && !ldc[n-1+col-row])
            {
                rc[row]=true;
                udc[row+col]=true;
                ldc[n-1+col-row]=true;
                curr[row][col]='Q';
                solve(col+1,n,curr,rc,udc,ldc,res);
                curr[row][col]='.';
                rc[row]=false;
                udc[row+col]=false;
                ldc[n-1+col-row]=false;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        char[][] curr=new char[n][n];
        for (int i=0;i<n;i++)
            for (int j=0;j<n;j++)
                curr[i][j]='.';

        boolean[] rc=new boolean[n];//row check
        boolean[] udc=new boolean[2*n-1];//upper diagonal check
        boolean[] ldc=new boolean[2*n-1];//lower diagonal check
        solve(0,n,curr,rc,udc,ldc,res);

        return res;
    }
}