class Tuple {
    int effort;
    int row;
    int col;

    Tuple(int effort,int row,int col) {
        this.effort = effort;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public static int[] dRow = {-1,0,1,0};
    public static int[] dCol = {0,1,0,-1};

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] minEffort = new int[m][n];
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x,y) -> Integer.compare(x.effort,y.effort));

        for (int[] arr: minEffort)
            Arrays.fill(arr, Integer.MAX_VALUE);

        minEffort[0][0] = 0;
        pq.add(new Tuple(0,0,0));

        while (!pq.isEmpty()) {
            Tuple curr = pq.poll();
            int currEffort = curr.effort;
            int currRow = curr.row;
            int currCol = curr.col;

            for (int i=0;i<4;i++) {
                int newRow = currRow + dRow[i];
                int newCol = currCol + dCol[i];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                    int currDiff = Math.abs(heights[currRow][currCol] - heights[newRow][newCol]);
                    int currRouteMaxDiff= Math.max(minEffort[currRow][currCol], currDiff);

                    if (minEffort[newRow][newCol] > currRouteMaxDiff) {
                        minEffort[newRow][newCol] = currRouteMaxDiff;
                        pq.add(new Tuple(currRouteMaxDiff,newRow,newCol));
                    }
                }
            }
        }

        return minEffort[m-1][n-1];
    }
}