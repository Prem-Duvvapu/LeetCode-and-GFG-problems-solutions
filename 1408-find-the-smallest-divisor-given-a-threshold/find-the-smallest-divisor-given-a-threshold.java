class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int low = 1;
        int high = (int)1e6;
        int res = high;

        while (low <= high) {
            int mid = low  + (high - low)/2;

            if (isPossible(mid,nums,threshold)) {
                res = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return res;
    }

    private boolean isPossible(int mid,int[] nums,int threshold) {
        long sum = 0;

        for (int val: nums) {
            sum += (val/mid);

            if (val%mid != 0)
                sum += 1;
        }

        return (sum <= (long)threshold);
    }
}