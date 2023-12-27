class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n=colors.length();
        int cost=0;
        int i=0;

        while (i<n) {
            int k=i+1;
            int maxVal=neededTime[i];

            while (k<n && colors.charAt(k)==colors.charAt(i)) {
                cost+=Math.min(neededTime[k],maxVal);
                maxVal=Math.max(maxVal,neededTime[k]);
                k++;
            }

            i=k;
        }

        return cost;
    }
}