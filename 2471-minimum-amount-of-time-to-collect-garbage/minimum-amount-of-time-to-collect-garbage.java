class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int n=garbage.length;
        int ans=0;
        int lastG=0,lastM=0,lastP=0;

        for (int i=0;i<n;i++)
        {
            String s=garbage[i];
            ans+=s.length();
            if (s.indexOf('G')!=-1)
                lastG=i;
            if (s.indexOf('M')!=-1)
                lastM=i;
            if (s.indexOf('P')!=-1)
                lastP=i;
        }

        int[] prefix=new int[n-1];
        prefix[0]=travel[0];
        for (int i=1;i<n-1;i++)
            prefix[i]=travel[i]+prefix[i-1];

        if (lastG>0)
            ans+=prefix[lastG-1];
        if (lastM>0)
            ans+=prefix[lastM-1];
        if (lastP>0)
            ans+=prefix[lastP-1];

        return ans;
    }
}