class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int left=0;
        int tCntRes=0;
        int fCnt=0;

        //change F to T
        for (int i=0;i<answerKey.length();i++)
        {
            if (answerKey.charAt(i)=='F')
                fCnt++;

            while (fCnt>k)
            {
                if (answerKey.charAt(left)=='F')
                    fCnt--;

                left++;
            }

            tCntRes=Math.max(i-left+1,tCntRes);
        }

        left=0;
        int fCntRes=0;
        int tCnt=0;

        //change T to F
        for (int i=0;i<answerKey.length();i++)
        {
            if (answerKey.charAt(i)=='T')
                tCnt++;

            while (tCnt>k)
            {
                if (answerKey.charAt(left)=='T')
                    tCnt--;

                left++;
            }

            fCntRes=Math.max(i-left+1,fCntRes);
        }

        return Math.max(tCntRes,fCntRes);
    }
}