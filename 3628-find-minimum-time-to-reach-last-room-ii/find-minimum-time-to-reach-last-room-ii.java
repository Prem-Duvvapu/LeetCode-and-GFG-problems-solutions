class Pair {
    int row;
    int col;
    int time;
    int move;

    public Pair(int row,int col,int time,int move) {
        this.row=row;
        this.col=col;
        this.time=time;
        this.move=move;
    }
}

class Solution {
    public static final int[] DROW={-1,0,1,0};
    public static final int[] DCOL={0,1,0,-1};

    public int minTimeToReach(int[][] moveTime) {
        int n=moveTime.length;
        int m=moveTime[0].length;
        boolean[][] visited=new boolean[n][m];
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y) -> Integer.compare(x.time,y.time));

        visited[0][0]=true;
        pq.add(new Pair(0,0,0,2));

        while (!pq.isEmpty()) {
            Pair top=pq.poll();
            int currRow=top.row;
            int currCol=top.col;
            int currTime=top.time;
            int currMove=top.move;

            if (currRow==n-1 && currCol==m-1)
                return currTime;

            for (int i=0;i<4;i++) {
                int newRow=currRow+DROW[i];
                int newCol=currCol+DCOL[i];

                if (newRow>=0 && newRow<n && newCol>=0 && newCol<m && !visited[newRow][newCol]) {
                    int newTime=Math.max(currTime,moveTime[newRow][newCol]);
                    visited[newRow][newCol]=true;
                    int newMove=(currMove==1) ? 2: 1;
                    pq.add(new Pair(newRow,newCol,newTime+newMove,newMove));
                }
            }
        }

        return -1;
    }
}