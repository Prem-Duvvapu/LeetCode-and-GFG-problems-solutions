class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n=blocks.length();
        int minOps=n;
        int currOps=0;

        int left=0;
        int right=0;
        while (right<k) {
            if (blocks.charAt(right)=='W')
                currOps++;
            right++;
        }

        minOps=Math.min(minOps,currOps);

        while (right<n) {
            if (blocks.charAt(left)=='W')
                currOps--;

            if (blocks.charAt(right)=='W')
                currOps++;

            minOps=Math.min(minOps,currOps);

            left++;
            right++;
        }

        return minOps;
    }
}