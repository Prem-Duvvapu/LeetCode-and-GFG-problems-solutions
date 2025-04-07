class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int maxScore=0;
        int currScore=0;
        int i=0;
        int j=n-1;

        while (i<k)
            maxScore+=cardPoints[i++];
        i--;

        currScore=maxScore;

        while (i>=0) {
            currScore-=cardPoints[i];
            currScore+=cardPoints[j];

            maxScore=Math.max(maxScore,currScore);

            i--;
            j--;
        }
        

        return maxScore;
    }
}