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

    private void solve(int col,int n,char[][] curr,List<List<String>> res)
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
            if (isValid(curr,row,col,n))
            {
                curr[row][col]='Q';
                solve(col+1,n,curr,res);
                curr[row][col]='.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        char[][] curr=new char[n][n];
        for (int i=0;i<n;i++)
            for (int j=0;j<n;j++)
                curr[i][j]='.';

        solve(0,n,curr,res);

        return res;
    }
}