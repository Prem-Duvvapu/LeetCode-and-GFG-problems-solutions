class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();

        int firstDiffIndex=-1;
        int secondDiffIndex=-1;
        int diffCnt=0;
        
        for (int i=0;i<s1.length();i++) {
            if (s1.charAt(i)!=s2.charAt(i)) {
                diffCnt++;

                if (firstDiffIndex==-1)
                    firstDiffIndex=i;
                else if (secondDiffIndex==-1)
                    secondDiffIndex=i;

                if (diffCnt > 2)
                    return false;
            }
        }

        if (diffCnt==0 || (diffCnt==2 && (s1.charAt(firstDiffIndex)==s2.charAt(secondDiffIndex) && s2.charAt(firstDiffIndex)==s1.charAt(secondDiffIndex))))
            return true;

        return false;
    }
}