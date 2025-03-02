class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;

        int low=0;
        int high=n-1;

        while (low<=high) {
            int mid=low+(high-low)/2;

            int rowIdx=maxRowIndex(mat,mid);
            int leftVal=(mid-1>=0) ? (mat[rowIdx][mid-1]) : -1;
            int rightVal=(mid+1<n) ? (mat[rowIdx][mid+1]) : -1;
 
            if (mat[rowIdx][mid]>leftVal && mat[rowIdx][mid]>rightVal)
                return new int[]{rowIdx,mid};
            else if (mat[rowIdx][mid]<leftVal)
                high=mid-1;
            else
                low=mid+1;
        }

        return new int[]{-1,-1};
    }

    public int maxRowIndex(int[][] mat,int col) {
        int maxi=0;
        int maxIndex=-1;

        for (int i=0;i<mat.length;i++) {
            if (mat[i][col]>maxi) {
                maxi=mat[i][col];
                maxIndex=i;
            }
        }

        return maxIndex;
    }
}