class Solution {
    public int maxScore(String s) {
        int n=s.length();
        int[] suffix=new int[n];
        int zeroCnt=0;
        int maxScore=0;

        suffix[n-1]=s.charAt(n-1)-'0';
        for (int i=n-2;i>=0;i--)
            suffix[i]=suffix[i+1]+s.charAt(i)-'0';
        
        for (int i=0;i<n-1;i++) {
            if (s.charAt(i)=='0')
                zeroCnt++;
            maxScore=Math.max(maxScore,zeroCnt+suffix[i+1]);
        }

        return maxScore;
    }
}