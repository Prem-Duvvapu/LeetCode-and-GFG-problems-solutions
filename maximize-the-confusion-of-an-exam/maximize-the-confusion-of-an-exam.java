class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int left=0;
        int res=0;
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

            res=Math.max(right-left+1,res);
        }

        left=0;
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

            res=Math.max(right-left+1,res);
        }

        return res;
    }
}