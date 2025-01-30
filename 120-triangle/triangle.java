class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[] next=new int[n];

        for (int j=0;j<n;j++)
            next[j]=triangle.get(n-1).get(j);

        for (int r=n-2;r>=0;r--) {
            int[] curr=new int[n];
            for (int c=r;c>=0;c--) {
                int below = next[c];
                int diagonal = next[c+1];
                curr[c]=triangle.get(r).get(c) + Math.min(below,diagonal);
            }

            for (int i=0;i<n;i++)
                next[i]=curr[i];
        }

        return next[0];
    }
}