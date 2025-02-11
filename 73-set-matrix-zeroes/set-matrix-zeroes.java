//Better
//T.C. : O(m*n)
//S.C. : O(m+n)
class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        boolean firstRowCheck=false;
        boolean firstColCheck=false;

        //check first row
        for (int j=0;j<n;j++) {
            if (matrix[0][j]==0) {
                firstRowCheck=true;
                break;
            }
        }

        //check first col
        for (int i=0;i<m;i++) {
            if (matrix[i][0]==0) {
                firstColCheck=true;
                break;
            }
        }

        for (int i=1;i<m;i++) {
            for (int j=1;j<n;j++) {
                if (matrix[i][j]==0) {
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }

        for (int i=1;i<m;i++)
            for (int j=1;j<n;j++)
                if (matrix[0][j]==0 || matrix[i][0]==0)
                    matrix[i][j]=0;

        if (firstRowCheck) {
            for (int j=0;j<n;j++)
                matrix[0][j]=0;
        }

        if (firstColCheck) {
            for (int i=0;i<m;i++)
                matrix[i][0]=0;
        }


    }
}