class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lb = findLowerBound(nums,target);
        int ub = findUpperBound(nums,target);

        if (lb == -1) {
            return new int[] {-1,-1};
        }

        return new int[] {lb,ub-1};
    }

    private int findLowerBound(int[] nums,int target) {
        int low = 0;
        int high = nums.length - 1;
        int res = -1;

        while (low <= high) {
            int mid = low + (high - low)/2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                res = mid;
                high = mid-1;
            }
        }

        return res;
    }

    private int findUpperBound(int[] nums,int target) {
        int low = 0;
        int high = nums.length - 1;
        int res = nums.length;

        while (low <= high) {
            int mid = low + (high - low)/2;
            if (nums[mid] > target) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;
    }
}