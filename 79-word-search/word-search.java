class Solution {
    private final int[] dRow = {-1,0,1,0};
    private final int[] dCol = {0,1,0,-1};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (solve(i,j,0,visited,board,word)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean solve(int r,int c,int pos,boolean[][] visited,char[][] board,String word) {
        if (pos >= word.length()) {
            return true;
        }

        if (r<0 || r>=board.length || c<0 || c>=board[0].length || visited[r][c]) {
            return false;
        }

        if (board[r][c] == word.charAt(pos)) {
            visited[r][c] = true;
            for (int i=0;i<4;i++) {
                boolean val = solve(r+dRow[i],c+dCol[i],pos+1,visited,board,word);
                if (val) {
                    return true;
                }
            }

            visited[r][c] = false;
        }

        return false;
    }
}