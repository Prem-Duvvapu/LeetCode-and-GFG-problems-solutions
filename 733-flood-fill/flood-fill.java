class Solution {
    public static int[] dRow = {-1,0,1,0};
    public static int[] dCol = {0,1,0,-1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int[][] res = new int[m][n];

        for (int i=0;i<m;i++)
            for (int j=0;j<n;j++)
                res[i][j] = image[i][j];

        if (image[sr][sc] == color)
            return image;

        dfs(sr,sc,res[sr][sc],color,res,m,n);

        return res;
    }

    private void dfs(int r,int c,int initialColor,int finalColor,int[][] res,int m,int n) {
        res[r][c] = finalColor;

        for (int i=0;i<4;i++) {
            int newRow = r + dRow[i];
            int newCol = c + dCol[i];

            if (newRow >=0 && newRow < m && newCol >= 0 && newCol < n && res[newRow][newCol] == initialColor)
                dfs(newRow,newCol,initialColor,finalColor,res,m,n);
        }
    }
}