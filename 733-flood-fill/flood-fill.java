class Solution {
    int[] dRow={-1,0,1,0}; //up,right,down,left
    int[] dCol={0,1,0,-1}; //up,right,down,left

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;

        if (image[sr][sc]==color)
            return image;

        int[][] res=new int[m][n];

        for (int i=0;i<m;i++)
            for (int j=0;j<n;j++)
                res[i][j]=image[i][j];

        int initialColor=image[sr][sc];

        dfs(sr,sc,res,initialColor,color,m,n);

        return res;
    }

    public void dfs(int r,int c,int[][] res,int initialColor,int finalColor,int m,int n) {
        res[r][c]=finalColor;

        for (int i=0;i<4;i++) {
            int newRow=r+dRow[i];
            int newCol=c+dCol[i];

            if (newRow>=0 && newRow<m && newCol>=0 && newCol<n && res[newRow][newCol]==initialColor)
                dfs(newRow,newCol,res,initialColor,finalColor,m,n);
        }
    }
}


/*

1 1 1   1 1 1  1 2 1  2 2 1  2 2 1  2 2 1  2 2 2
1 1 0 ->1 2 0->1 2 0->1 2 0->2 2 0->2 2 0->2 2 0
1 0 1   1 0 1  1 0 1  1 0 1  1 0 1  2 0 1  2 0 1

up,down,left,right

*/