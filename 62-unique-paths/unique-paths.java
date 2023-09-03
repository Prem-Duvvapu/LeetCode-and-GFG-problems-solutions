//Space Optimization

class Solution {
    int mod=(int)(2e9);

    public int uniquePaths(int m, int n) {
        int[] prev=new int[n];
        int[] curr=new int[n];
        
        for (int i=0;i<m;i++)
        {
            for (int j=0;j<n;j++)
            {
                if (i==0 && j==0)
                    curr[j]=1;
                else
                {
                    int left=0;
                    int top=0;

                    if (j-1>=0)
                        left=curr[j-1];
                    
                    if (i-1>=0)
                        top=prev[j];

                    curr[j]=(left+top)%mod;
                }
            }

            for (int k=0;k<n;k++)
                prev[k]=curr[k];
        }

        return prev[n-1];
    }
}