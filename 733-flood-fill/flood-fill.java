class Solution {
    private static final int[] dRow = {-1,0,1,0};
    private static final int[] dCol = {0,1,0,-1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startColor = image[sr][sc];

        if (startColor == color) {
            return image;
        }

        int[][] res = new int[image.length][image[0].length];
        for (int i=0;i<image.length;i++) {
            for (int j=0;j<image[0].length;j++) {
                res[i][j] = image[i][j];
            }
        }

        dfs(sr,sc,res,color,image,startColor);
        return res;
    }

    private void dfs(int r,int c,int[][] res,int finalColor,int[][] image,int startColor) {
        res[r][c] = finalColor;
        for (int i=0;i<4;i++) {
            int newRow = r + dRow[i];
            int newCol = c + dCol[i];
            if (newRow >=0 && newRow < image.length && newCol >= 0 && newCol < image[0].length && image[newRow][newCol] == startColor && res[newRow][newCol] != finalColor) {
                dfs(newRow,newCol,res,finalColor,image,startColor);
            }
        }
    }
}