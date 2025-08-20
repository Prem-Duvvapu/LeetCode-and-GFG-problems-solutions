class Pair {
    int row;
    int col;

    Pair(int row,int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public static int[] dRow = {-1,0,1,0};
    public static int[] dCol = {0,1,0,-1};

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] res = new int[m][n];

        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (mat[i][j] == 0)
                    q.add(new Pair(i,j));
            }
        }

        bfs(q,res,mat,m,n);
        return res;
    }

    public void bfs(Queue<Pair> q, int[][] res,int[][] matrix,int m,int n) {
        int dist = 1;

        while (!q.isEmpty()) {
            int qlen = q.size();

            while (qlen-- > 0) {
                Pair curr = q.poll();
                int currRow = curr.row;
                int currCol = curr.col;
                
                for (int i=0;i<4;i++) {
                    int newRow = currRow + dRow[i];
                    int newCol = currCol + dCol[i];

                    if (newRow>=0 && newRow<m && newCol>=0 && newCol<n && matrix[newRow][newCol]==1 && res[newRow][newCol]==0) {
                        res[newRow][newCol] = dist;
                        q.add(new Pair(newRow, newCol));
                    }
                }
            }

            dist++;
        }
    }
}