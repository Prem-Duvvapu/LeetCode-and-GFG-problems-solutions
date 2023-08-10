//Striver's approach

class Solution {
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
            if (!rc[row] && !udc[row+col] && !ldc[n-1+col-row]) //is safe or not
            {
                //mark as present
                rc[row]=true;
                udc[row+col]=true;
                ldc[n-1+col-row]=true;

                curr[row][col]='Q';
                solve(col+1,n,curr,rc,udc,ldc,res);

                //remove mark
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