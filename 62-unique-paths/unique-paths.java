//Space Optimization

class Solution {
    int mod=2000000000;

    public int uniquePaths(int m, int n) {
        int[] prev=new int[n];

        for (int i=0;i<m;i++)
        {
            int[] curr=new int[n];
            for (int j=0;j<n;j++)
            {
                if (i==0 && j==0)
                    curr[j]=1;
                else
                {
                    int up=0;
                    int left=0;

                    if (i>0)
                        up=prev[j];

                    if (j>0)
                        left=curr[j-1];

                    curr[j]=(up+left)%mod;
                }
            }
            for (int k=0;k<n;k++)
                prev[k]=curr[k];
        }

        return prev[n-1];
    }
}