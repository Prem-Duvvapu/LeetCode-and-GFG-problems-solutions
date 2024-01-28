class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int cnt=0;

        for (int i=0;i<m;i++)
            for (int j=1;j<n;j++)
                matrix[i][j]+=matrix[i][j-1];

        for (int c1=0;c1<n;c1++) {
            for (int c2=c1;c2<n;c2++) {
                Map<Integer,Integer> map=new HashMap<>();
                map.put(0,1);
                int currSum=0;

                for (int row=0;row<m;row++) {
                    currSum+=matrix[row][c2];
                    if (c1>0)
                        currSum-=matrix[row][c1-1];

                    cnt+=map.getOrDefault(currSum-target,0);
                    map.put(currSum,map.getOrDefault(currSum,0)+1);
                }
            }
        }

        return cnt;
    }
}