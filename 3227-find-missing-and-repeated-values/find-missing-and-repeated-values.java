class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        long num=n*n;

        long sumOfN=(num*(num+1))/2;
        long sumOfSqOfN=(num*(num+1)*(2*num+1))/6;

        long sumOfGrid=0;
        long sumOfSqOfGrid=0;

        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                sumOfGrid+=grid[i][j];
                sumOfSqOfGrid+=((long)grid[i][j]*grid[i][j]);
            }
        }

        // System.out.println(sumOfN);
        // System.out.println(sumOfSqOfN);
        // System.out.println(sumOfGrid);
        // System.out.println(sumOfSqOfGrid);

        long x=sumOfGrid-sumOfN; //a-b
        long y=sumOfSqOfGrid-sumOfSqOfN; //a^2-b^2=(a+b)*(a-b)=(a+b)*x;
        /*
        y=(a+b)*x;
        a+b=y/x;
        a-b=x;
        2*a=y/x+x;
        */
        int a=(int)(y/x+x)/2;
        int b=(int)(a-x);

        return new int[]{a,b};
    }
}