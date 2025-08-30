class Tuple {
    int dist;
    int row;
    int col;

    Tuple(int dist,int row,int col) {
        this.dist = dist;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public static int[] dRow = {-1,-1,0,1,1,1,0,-1};
    public static int[] dCol = {0,1,1,1,0,-1,-1,-1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0)
            return -1;

        int n = grid.length;
        Queue<Tuple> q = new LinkedList<>();
        int[][] dist = new int[n][n];

        for (int[] arr: dist)
            Arrays.fill(arr,Integer.MAX_VALUE);

        dist[0][0] = 1;
        q.add(new Tuple(dist[0][0],0,0));

        while (!q.isEmpty()) {
            Tuple curr = q.poll();
            int currDist = curr.dist;
            int currRow = curr.row;
            int currCol = curr.col;

            if (currRow == n-1 && currCol == n-1)
                return currDist;

            for (int i=0;i<8;i++) {
                int newRow = currRow + dRow[i];
                int newCol = currCol + dCol[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0 && dist[newRow][newCol] > dist[currRow][currCol] + 1) {
                    dist[newRow][newCol] = dist[currRow][currCol] + 1;
                    q.add(new Tuple(dist[newRow][newCol], newRow, newCol));
                }
            }
        }

        return -1;
    }
}