class Solution {
    public int distinctSubseqII(String s) {
        long mod=(long)(1e9)+7;
        long[] endsWith=new long[26];

        for (char ch: s.toCharArray())
        {
            long sum=0;
            for (int i=0;i<26;i++)
                sum=(sum+endsWith[i])%mod;

            endsWith[ch-'a']=sum+1;
        }

        long sum=0;
        for (int i=0;i<26;i++)
            sum=(sum+endsWith[i])%mod;

        return (int)sum;
    }
}