class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int left=0;
        int tCntRes=0;
        int fCnt=0;

        //change F to T
        for (int right=0;right<answerKey.length();right++)
        {
            if (answerKey.charAt(right)=='F')
                fCnt++;

            while (fCnt>k)
            {
                if (answerKey.charAt(left)=='F')
                    fCnt--;

                left++;
            }

            tCntRes=Math.max(right-left+1,tCntRes);
        }

        left=0;
        int fCntRes=0;
        int tCnt=0;

        //change T to F
        for (int right=0;right<answerKey.length();right++)
        {
            if (answerKey.charAt(right)=='T')
                tCnt++;

            while (tCnt>k)
            {
                if (answerKey.charAt(left)=='T')
                    tCnt--;

                left++;
            }

            fCntRes=Math.max(right-left+1,fCntRes);
        }

        return Math.max(tCntRes,fCntRes);
    }
}