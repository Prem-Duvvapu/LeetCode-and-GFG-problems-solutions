class Solution {
    public int minAddToMakeValid(String s) {
        int res=0;
        int openCnt=0;

        for (char ch: s.toCharArray()) {
            if (ch=='(')
                openCnt++;
            else
                openCnt--;
            
            if (openCnt<0) {
                res+=Math.abs(openCnt);
                openCnt=0;
            }
        }

        if (openCnt>0)
            res+=Math.abs(openCnt);
        return res;
    }
}