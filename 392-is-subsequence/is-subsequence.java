class Solution {
    public boolean isSubsequence(String s, String t) {
        int sp=0;
        int tp=0;

        if (s.length()==0)
            return true;

        while (tp<t.length())
        {
            if (s.charAt(sp)==t.charAt(tp))
            {
                sp++;
                tp++;
            }
            else
                tp++;

            if (sp==s.length())
                return true;
        }

        return false;
    }
}