class Solution {
    private boolean isValid(char[][] curr,int row,int col,int n)
    {
        for (int i=0;i<n;i++)
        {
            if (curr[row][i]=='Q')
                return false;
        }

        int x=row;
        int y=col;
        while (x>=0 && y>=0)
        {
            if (curr[x][y]=='Q')
                return false;
            x--;
            y--;
        }

        x=row;
        y=col;
        while (x<n && y<n)
        {
            if (curr[x][y]=='Q')
                return false;
            x++;
            y++;
        }

        x=row;
        y=col;
        while (x>=0 && y<n)
        {
            if (curr[x][y]=='Q')
                return false;
            x--;
            y++;
        }

        x=row;
        y=col;
        while (x<n && y>=0)
        {
            if (curr[x][y]=='Q')
                return false;
            x++;
            y--;
        }

        return true;
    }

    private boolean solve(int pos,int n,char[][] curr,List<List<String>> res)
    {
        if (pos==n)
        {
            List<String> l=new ArrayList<>();
            for (char[] arr: curr)
                l.add(new String(arr));
            
            res.add(l);
            return false;
        }

        for (int j=pos;j<n;j++) //column
        {
            for (int i=0;i<n;i++) //row
            {
                if (isValid(curr,i,j,n))
                {
                    curr[i][j]='Q';
                    if (!solve(j+1,n,curr,res))
                        curr[i][j]='.';
                }
            }
            return false;
        }
        return true;
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