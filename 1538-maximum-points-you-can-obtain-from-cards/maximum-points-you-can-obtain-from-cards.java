class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int maxSum = 0;
        int currSum = 0;

        for (int i=0;i<k;i++) {
            currSum += cardPoints[i];
        }

        maxSum = currSum;

        int i = 0;
        int j = k-1;

        while (j>=0) {
            currSum -= cardPoints[j];
            j--;
            i--;

            i = (i+n)%n;
            currSum += cardPoints[i];
            maxSum = Math.max(currSum, maxSum);
        }

        return maxSum;
    }
}