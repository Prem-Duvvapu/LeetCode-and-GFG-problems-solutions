class Solution {
    public boolean checkValidString(String s) {
        int n=s.length();

        //left to right
        int openCnt=0;
        int closeCnt=0;
        int symbolCnt=0;

        for (char ch: s.toCharArray()) {
            if (ch=='(')
                openCnt++;
            else if (ch==')') {
                closeCnt++;
                if (closeCnt>openCnt+symbolCnt)
                    return false;
            } else
                symbolCnt++;
        }

        //right to left
        openCnt=0;
        closeCnt=0;
        symbolCnt=0;
        for (char ch: new StringBuilder(s).reverse().toString().toCharArray()) {
            if (ch=='(') {
                openCnt++;
                if (openCnt>closeCnt+symbolCnt)
                    return false;
            } else if (ch==')')
                closeCnt++;
            else
                symbolCnt++;  
        }

        return true;
    }
}