class Solution {
    int[] dx={-1,0,1,0};
    int[] dy={0,1,0,-1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        int[][] res=new int[m][n];
        boolean[][] visited=new boolean[m][n];

        for (int i=0;i<m;i++)
            for (int j=0;j<n;j++)
                res[i][j]=image[i][j];

        dfs(sr,sc,res[sr][sc],color,visited,res,m,n);

        return res;
    }

    private void dfs(int r,int c,int prev,int color,boolean[][] visited,int[][] res,int m,int n) {
        res[r][c]=color;
        visited[r][c]=true;

        for (int i=0;i<4;i++)
        {
            int newRow=r+dx[i];
            int newCol=c+dy[i];
            if (newRow>=0 && newRow<m && newCol>=0 && newCol<n && res[newRow][newCol]==prev && !visited[newRow][newCol]) {
                res[newRow][newCol]=color;
                visited[newRow][newCol]=true;
                dfs(newRow,newCol,prev,color,visited,res,m,n);
            }
        }
    }
}