class Solution {
    public int[] findArray(int[] pref) {
        int n=pref.length;
        int[] res=new int[n];
        int[] prefix=new int[n];
        res[0]=pref[0];
        prefix[0]=pref[0];

        for (int i=1;i<n;i++)
        {
            res[i]=prefix[i-1]^pref[i];
            prefix[i]=prefix[i-1]^res[i];
        }

        return res;
    }
}