class Solution {
    public boolean checkValidString(String s) {
        int n=s.length();
        int openCnt=0;
        int closeCnt=0;
        int symbolCnt=0;

        for (int i=n-1;i>=0;i--) {
            char ch=s.charAt(i);
            if (ch=='(') {
                openCnt++;
                if (openCnt>closeCnt+symbolCnt)
                    return false;
            } else if (ch==')') {
                closeCnt++;
            } else {
                symbolCnt++;
            }
        }

        openCnt=0;
        closeCnt=0;
        symbolCnt=0;

        for (int i=0;i<n;i++) {
            char ch=s.charAt(i);
            if (ch==')') {
                closeCnt++;
                if (closeCnt>openCnt+symbolCnt)
                    return false;
            } else if (ch=='(') {
                openCnt++;
            } else {
                symbolCnt++;
            }
        }

        openCnt=0;
        closeCnt=0;
        symbolCnt=0;

        for (int i=0;i<n;i++) {
            char ch=s.charAt(i);
            if (ch=='(') {
                openCnt++;
            } else if (ch==')') {
                closeCnt++;
                if (closeCnt>openCnt+symbolCnt)
                    return false;
            } else {
                symbolCnt++;
            }
        }

        if (Math.abs(openCnt-closeCnt)>symbolCnt)
            return false;

        return true;
    }
}