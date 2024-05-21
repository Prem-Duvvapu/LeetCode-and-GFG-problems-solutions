class Pair {
    int dist;
    int row;
    int col;
    Pair(int _dist,int _row,int _col) {
        dist=_dist;
        row=_row;
        col=_col;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        Queue<Pair> q=new LinkedList<>();
        int[][] dist=new int[n][n];

        for (int[] a: dist)
            Arrays.fill(a,(int)1e9);

        if (grid[0][0]==1 || grid[n-1][n-1]==1)
            return -1;

        q.add(new Pair(0,0,0));
        dist[0][0]=1;

        int[] drow={-1,-1,-1,0,1,1,1,0};
        int[] dcol={-1,0,1,1,1,0,-1,-1};

        while (!q.isEmpty()) {
            Pair curr=q.poll();

            for (int i=0;i<8;i++) {
                int newRow=curr.row+drow[i];
                int newCol=curr.col+dcol[i];

                if (newRow>=0 && newRow<n && newCol>=0 && newCol<n && grid[newRow][newCol]==0 && dist[curr.row][curr.col]+1<dist[newRow][newCol]) {
                    dist[newRow][newCol]=dist[curr.row][curr.col]+1;
                    q.add(new Pair(dist[newRow][newCol],newRow,newCol));
                }
            }
        }

        return (dist[n-1][n-1]!=(int)1e9) ? dist[n-1][n-1] : -1;
    }
}