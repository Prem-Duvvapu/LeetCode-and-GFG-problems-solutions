class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length()!=goal.length())
            return false;

        return kmp(s+s,goal);
    }

    public boolean kmp(String text,String pattern) {
        int n=text.length();
        int m=pattern.length();

        int[] lps=new int[m];
        lps[0]=0;
        int i=0;
        int j=1;
        int currLength=0;

        while (j<m) {
            if (pattern.charAt(j)==pattern.charAt(currLength)) {
                currLength++;
                lps[j]=currLength;
                j++;
            } else {
                if (currLength==0) {
                    lps[j]=currLength;
                    j++;
                } else {
                    currLength=lps[currLength-1];
                }
            }
        }

        j=0;
        while (i<n && j<m) {
            if (text.charAt(i)==pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (j==0)
                    i++;
                else
                    j=lps[j-1];
            }

            if (j==m)
                return true;
        }

        return false;
    }
}