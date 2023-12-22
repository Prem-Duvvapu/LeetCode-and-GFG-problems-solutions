class Solution {
    public int maxScore(String s) {
        int n=s.length();
        int[] suffix=new int[n];
        int zeroCnt=0;
        int oneCnt=0;
        int maxScore=0;

        for (int i=0;i<n;i++)
            if (s.charAt(i)=='1')
                oneCnt++;
        
        for (int i=0;i<n-1;i++) {
            if (s.charAt(i)=='0')
                zeroCnt++;
            else
                oneCnt--;
            maxScore=Math.max(maxScore,zeroCnt+oneCnt);
        }

        return maxScore;
    }
}