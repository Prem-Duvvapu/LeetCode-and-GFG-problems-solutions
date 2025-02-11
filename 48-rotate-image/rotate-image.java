//Optimal
//T.C. : O(n*n)
//S.C. : O(1)

/*
Steps
1. transpose the matrix
2. reverse each row after transposing the matrix
*/

class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
            
        for (int i=0;i<n;i++)
            for (int j=i;j<n;j++)
                swap(matrix,i,j,j,i);

        for (int i=0;i<n;i++)
            reverse(matrix,i,0,n-1);
    }

    public void swap(int[][] matrix,int r1,int c1,int r2,int c2) {
        int temp=matrix[r1][c1];
        matrix[r1][c1]=matrix[r2][c2];
        matrix[r2][c2]=temp;
    }

    public void reverse(int[][] matrix,int row,int colStart,int colEnd) {
        while (colStart<colEnd) {
            int temp=matrix[row][colStart];
            matrix[row][colStart]=matrix[row][colEnd];
            matrix[row][colEnd]=temp;
            colStart++;
            colEnd--;
        }
    }
}