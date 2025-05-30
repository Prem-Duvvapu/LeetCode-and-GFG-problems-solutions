class Solution {
    public static final long MOD=1_000_000_007;

    public String longestPrefix(String s) {
        int n=s.length();
        long p1=29;
        long p2=31;
        long[] power1=new long[n];
        long[] power2=new long[n];
        long prefixHash1=0;
        long prefixHash2=0;
        long suffixHash1=0;
        long suffixHash2=0;
        int maxLength=0;

        power1[0]=power2[0]=1;
        for (int i=1;i<n;i++) {
            power1[i]=(power1[i-1]*p1)%MOD;
            power2[i]=(power2[i-1]*p2)%MOD;
        }

        for (int i=0;i<n-1;i++) {
            int leftVal=s.charAt(i)-'a'+1;
            int rightVal=s.charAt(n-1-i)-'a'+1;

            prefixHash1=(prefixHash1+leftVal*power1[i])%MOD;
            prefixHash2=(prefixHash2+leftVal*power2[i])%MOD;

            suffixHash1=((suffixHash1*p1)+rightVal)%MOD;
            suffixHash2=((suffixHash2*p2)+rightVal)%MOD;

            if (prefixHash1==suffixHash1 && prefixHash2==suffixHash2)
                maxLength=i+1;
        }

        return s.substring(0,maxLength);
    }
}