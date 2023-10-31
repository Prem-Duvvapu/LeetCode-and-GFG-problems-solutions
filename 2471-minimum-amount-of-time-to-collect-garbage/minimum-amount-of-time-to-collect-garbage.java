class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int n=garbage.length;
        int ans=0;
        int lastM=0,lastP=0,lastG=0;
        int[] g=new int[n];
        int[] m=new int[n];
        int[] p=new int[n];

        for (int i=0;i<n;i++)
        {
            String curr=garbage[i];
            for (char ch: curr.toCharArray())
            {
                if (ch=='G')
                    g[i]++;
                else if (ch=='M')
                    m[i]++;
                else
                    p[i]++;
            }
            if (g[i]>0)
                lastG=i;
            if (m[i]>0)
                lastM=i;
            if (p[i]>0)
                lastP=i;
        }

        //for G
        for (int i=0;i<lastG;i++)
        {
            ans+=g[i];
            ans+=travel[i];
        }
        ans+=g[lastG];

        //for M
        for (int i=0;i<lastM;i++)
        {
            ans+=m[i];
            ans+=travel[i];
        }
        ans+=m[lastM];

        //for P
        for (int i=0;i<lastP;i++)
        {
            ans+=p[i];
            ans+=travel[i];
        }
        ans+=p[lastP];

        return ans;
    }
}