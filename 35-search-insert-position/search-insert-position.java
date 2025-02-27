//upper bound
class Solution {
    public int searchInsert(int[] nums, int target) {
        int n=nums.length;
        return upperBound(0,n-1,nums,target);
    }

    public int upperBound(int low,int high,int[] nums,int target) {
        int res=nums.length;
        while (low<=high) {
            int mid=low+(high-low)/2;

            if (nums[mid]==target) {
                return mid;
            } else if (target<nums[mid]) {
                res=mid;
                high=mid-1;
            } else {
                low=mid+1;
            }
        }

        return res;
    }
}