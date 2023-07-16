class Solution {
    public boolean isSubsequence(String s, String t) {
        int sLen=s.length();
        int tLen=t.length();

        if (sLen==0)
            return true;

        if (tLen==0)
            return false;

        int index=0;

        for (int i=0;i<tLen;i++)
        {
            if (t.charAt(i)==s.charAt(index))
                index++;

            if (index==sLen)
                return true;
        }

        return false;
    }
}