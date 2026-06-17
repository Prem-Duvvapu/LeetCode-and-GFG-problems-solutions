class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        boolean[] isRowFilled = new boolean[n];
        boolean[] isUpperDiagFilled = new boolean[2*n];
        boolean[] isLowerDiagFilled = new boolean[2*n];

        char[][] board = new char[n][n];
        for (char[] row: board) {
            Arrays.fill(row, '.');
        }

        solve(0,isRowFilled,isUpperDiagFilled,isLowerDiagFilled,board,n,res);
        return res;
    }

    private void solve(int col,boolean[] isRowFilled,boolean[] isUpperDiagFilled,boolean[] isLowerDiagFilled, char[][] board,int n,List<List<String>> res) {
        if (col == n) {
            List<String> currBoard = new ArrayList<>();
            for (char[] row: board) {
                String currRow = new String(row);
                currBoard.add(currRow);
            }
            res.add(currBoard);
            return;
        }

        for (int i=0;i<n;i++) {
            if (isValid(i,col,isRowFilled,isUpperDiagFilled,isLowerDiagFilled,n)) {
                board[i][col] = 'Q';
                fillCells(i,col,isRowFilled,isUpperDiagFilled,isLowerDiagFilled,n);

                solve(col+1,isRowFilled,isUpperDiagFilled,isLowerDiagFilled,board,n,res);

                board[i][col] = '.';
                unFillCells(i,col,isRowFilled,isUpperDiagFilled,isLowerDiagFilled,n);
            }
        }
    }

    private boolean isValid(int row,int col,boolean[] isRowFilled,boolean[] isUpperDiagFilled,boolean[] isLowerDiagFilled,int n) {
        // rowCheck
        if (isRowFilled[row]) {
            return false;
        }

        // upperDiag check
        if (isUpperDiagFilled[n-1+row-col]) {
            return false;
        }

        // lowerDiag check
        if (isLowerDiagFilled[row+col]) {
            return false;
        }

        return true;
    }

    private void fillCells(int row,int col,boolean[] isRowFilled,boolean[] isUpperDiagFilled,boolean[] isLowerDiagFilled,int n) {
        isRowFilled[row] = true;
        isUpperDiagFilled[n-1+row-col] = true;
        isLowerDiagFilled[row+col] = true;
    }

    private void unFillCells(int row,int col,boolean[] isRowFilled,boolean[] isUpperDiagFilled,boolean[] isLowerDiagFilled,int n) {
        isRowFilled[row] = false;
        isUpperDiagFilled[n-1+row-col] = false;
        isLowerDiagFilled[row+col] = false;
    }
}