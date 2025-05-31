class Solution {
    public static final long MOD=1_000_000_007;

    public String shortestPalindrome(String s) {
        int n=s.length();
        long power=31;
        long currPower=1;
        long prefixHash=0;
        long suffixHash=0;
        int longestPalindromeLen=0;

        for (int i=0;i<n;i++) {
            int val=s.charAt(i)-'a'+1;

            prefixHash=(prefixHash+val*currPower)%MOD;
            suffixHash=(suffixHash*power+val)%MOD;

            if (prefixHash==suffixHash)
                longestPalindromeLen=i+1;

            currPower=(currPower*power)%MOD;
        }

        StringBuilder res=new StringBuilder(s.substring(longestPalindromeLen));
        res.reverse();
        res.append(s);

        return res.toString();
    }
}