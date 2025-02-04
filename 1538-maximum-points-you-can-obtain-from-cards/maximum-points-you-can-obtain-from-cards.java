class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int x=n-k;
        int maxSum=0;
        int totalSum=0;

        for (int i=0;i<n;i++)
            totalSum+=cardPoints[i];

        int l=0,r=0;
        int currSum=0;

        while (r<x)
            currSum+=cardPoints[r++];

        maxSum=Math.max(maxSum,totalSum-currSum);

        while (r<n) {
            currSum-=cardPoints[l];
            currSum+=cardPoints[r];
            l++;
            r++;

            maxSum=Math.max(maxSum,totalSum-currSum);
        }

        return maxSum;
    }
}