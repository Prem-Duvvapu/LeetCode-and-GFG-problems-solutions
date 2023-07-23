class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int left=0;
        int right=m*n-1;
        return binSearch(matrix,left,right,n,target);
    }

    private boolean binSearch(int[][] matrix,int left,int right,int col,int target)
    {
        while (left<=right)
        {
            int mid=left+(right-left)/2;
            int r=mid/col;
            int c=mid%col;
            if (matrix[r][c]==target)
                return true;
            else if (matrix[r][c]<target)
                left=mid+1;
            else
                right=mid-1;
        }
        return false;
    }
}