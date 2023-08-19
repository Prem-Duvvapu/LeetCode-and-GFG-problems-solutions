//Space Optimization

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[] next=new int[n];
        
        for (int i=0;i<n;i++)
            next[i]=triangle.get(n-1).get(i);

        for (int i=n-2;i>=0;i--)
        {
            int[] curr=new int[i+1];
            for (int j=0;j<=i;j++)
            {
                int down=next[j];
                int diag=next[j+1];
                curr[j]=triangle.get(i).get(j)+Math.min(down,diag);
            }
            System.arraycopy(curr,0,next,0,i+1);
        }

        return next[0];
    }
}