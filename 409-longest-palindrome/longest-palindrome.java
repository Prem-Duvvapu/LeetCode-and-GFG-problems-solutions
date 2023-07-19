class Solution {
    public int longestPalindrome(String s) {
        int res=0;
        int[] lower=new int[26];
        int[] upper=new int[26];
        int oddMax=0;

        for (char ch: s.toCharArray())
        {
            if (Character.isLowerCase(ch))
                lower[ch-'a']++;
            else
                upper[ch-'A']++;
        }

        for (int i=0;i<26;i++)
        {
            if ((lower[i]&1)==1) //odd
                res+=(lower[i]-1);
            else
                res+=lower[i];
        }

        for (int i=0;i<26;i++)
        {
            if ((upper[i]&1)==1) //odd
                res+=(upper[i]-1);
            else
                res+=upper[i];
        }

        if (res==s.length()) //all characters are even
            return res;

        return res+1;
    }
}