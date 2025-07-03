class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i=0;i<n;i++) {
            for (int j=i+1;j<n;j++) {
                swap(matrix,i,j,j,i);
            }
        }

        for (int i=0;i<n;i++)
            reverse(matrix[i]);
    }

    private void swap(int[][] a,int i,int j,int x,int y) {
        int temp = a[i][j];
        a[i][j] = a[x][y];
        a[x][y] = temp;
    }

    private void swap(int[] a,int i,int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private void reverse(int[] a) {
        int low = 0;
        int high = a.length-1;

        while (low<high) {
            swap(a,low,high);
            low++;
            high--;
        }
    }
}