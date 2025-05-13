class Solution {
    public static final long MOD=1_000_000_007L;

    public int lengthAfterTransformations(String s, int t) {
        long res=0L;
        long[] prev=new long[26];
        long[] curr=new long[26];

        for (char ch: s.toCharArray())
            prev[ch-'a']++;

        for (int i=0;i<t;i++) {
            Arrays.fill(curr,0L);

            for (int j=0;j<25;j++)
                curr[j+1]=(curr[j+1]+prev[j])%MOD;

            //z -> ab
            curr[0]=(curr[0]+prev[25])%MOD;
            curr[1]=(curr[1]+prev[25])%MOD;

            System.arraycopy(curr,0,prev,0,curr.length); 
        }

        for (long val: prev)
            res=(res+val)%MOD;

        return (int)res;
    }
}