class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for (int i=0;i<n;i++)
        {
            for (int j=0;j<n-i-1;j++)
            {
                int k=n-i-j-1;
                swap(matrix,i,j,i+k,j+k);
            }
        }

        int top=0;
        int bottom=n-1;
        while (top<bottom)
        {
            for (int i=0;i<n;i++)
                swap(matrix,top,i,bottom,i);
            
            top++;
            bottom--;
        }
    }

    private void swap(int[][] matrix,int r1,int c1,int r2,int c2)
    {
        int temp=matrix[r1][c1];
        matrix[r1][c1]=matrix[r2][c2];
        matrix[r2][c2]=temp;
    }
}