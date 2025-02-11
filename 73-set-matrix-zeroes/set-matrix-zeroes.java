//Better
//T.C. : O(m*n)
//S.C. : O(m+n)
class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[] rowsMark=new int[m];
        int[] colsMark=new int[n];

        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (matrix[i][j]==0) {
                    rowsMark[i]=1;
                    colsMark[j]=1;
                }
            }
        }

        for (int i=0;i<m;i++)
            if (rowsMark[i]==1)
                for (int j=0;j<n;j++)
                    matrix[i][j]=0;

        for (int j=0;j<n;j++)
            if (colsMark[j]==1)
                for (int i=0;i<m;i++)
                    matrix[i][j]=0;
    }
}