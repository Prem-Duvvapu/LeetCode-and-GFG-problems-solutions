class Solution {
    public int n;

    public int snakesAndLadders(int[][] board) {
        n=board.length;
        boolean[][] visited=new boolean[n][n];
        Queue<Integer> q=new LinkedList<>();
        int steps=0;

        q.add(1);
        visited[n-1][0]=true;

        while (!q.isEmpty()) {
            int qlen=q.size();

            while (qlen-- > 0) {
                int curr=q.poll();

                if (curr==n*n)
                    return steps;

                for (int i=1;i<=6;i++) {
                    int next=curr+i;

                    if (next>n*n)
                        break;

                    int[] rowCol=getCoordinates(next);
                    int row=rowCol[0];
                    int col=rowCol[1];

                    if (visited[row][col])
                        continue;

                    visited[row][col]=true;

                    if (board[row][col]==-1)
                        q.add(next);
                    else
                        q.add(board[row][col]);
                }
            }

            steps++;
        }
        
        return -1;
    }

    public int[] getCoordinates(int cellNum) {
        int row=(n-1)-(cellNum-1)/n;
        int col=(cellNum-1)%n;

        if ((n%2==0 && row%2==0) || (n%2==1 && row%2==1))
            col=n-1-col;

        return new int[]{row,col};
    }
}