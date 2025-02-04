class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        Arrays.sort(citations);
        int res=0;

        for (int i=0;i<n;i++) {
            int diff=(n-i);
            if (citations[i]>=diff) {
                res=diff;
                break;
            }
        }

        return res;
    }
}