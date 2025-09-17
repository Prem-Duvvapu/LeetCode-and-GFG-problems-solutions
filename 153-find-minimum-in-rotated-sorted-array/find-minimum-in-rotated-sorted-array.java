class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int minVal = Integer.MAX_VALUE;
        int low = 0;
        int high = n-1;

        while (low <= high) {
            int mid = low + (high - low)/2;

            if (nums[low] <= nums[mid]) {
                minVal = Math.min(minVal, nums[low]);
                low = mid+1;
            } else {
                minVal = Math.min(minVal, nums[mid]);
                high = mid-1;
            }
        }

        return minVal;
    }
}