class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int maxSum=0;

        //from front
        int currSum=0;
        for (int i=0;i<k;i++)
            currSum+=cardPoints[i];

        maxSum=Math.max(currSum,maxSum);

        int j=k-1;
        int r=n-1;
        while (j>=0) {
            currSum-=cardPoints[j];
            currSum+=cardPoints[r];
            maxSum=Math.max(currSum,maxSum);

            j--;
            r--;
        }

        return maxSum;
    }
}