class Solution {
    private int n;
    private boolean[] isRowFilled, isUpperDiagFilled, isLowerDiagFilled;
    private char[][] board;
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.isRowFilled = new boolean[n];
        this.isUpperDiagFilled = new boolean[2 * n];
        this.isLowerDiagFilled = new boolean[2 * n];
        this.board = new char[n][n];
        this.res = new ArrayList<>();

        for (char[] row : board) Arrays.fill(row, '.');

        solve(0);
        return res;
    }

    private void solve(int col) {
        if (col == n) {
            List<String> currBoard = new ArrayList<>();
            for (char[] row : board) currBoard.add(new String(row));
            res.add(currBoard);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isValid(row, col)) {
                mark(row, col, true);
                board[row][col] = 'Q';

                solve(col + 1);

                mark(row, col, false);
                board[row][col] = '.';
            }
        }
    }

    private boolean isValid(int row, int col) {
        return !isRowFilled[row]
            && !isUpperDiagFilled[n - 1 + row - col]
            && !isLowerDiagFilled[row + col];
    }

    private void mark(int row, int col, boolean val) {
        isRowFilled[row] = val;
        isUpperDiagFilled[n - 1 + row - col] = val;
        isLowerDiagFilled[row + col] = val;
    }
}