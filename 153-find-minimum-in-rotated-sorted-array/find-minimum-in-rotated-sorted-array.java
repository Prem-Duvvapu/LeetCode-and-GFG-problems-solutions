class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        int res=Integer.MAX_VALUE;

        while (low<=high) {
            int mid=low+(high-low)/2;

            if (nums[low]<=nums[mid] && nums[mid]<=nums[high]) {
                res=Math.min(res,nums[low]);
                return res;
            }

            //if left half is sorted
            if (nums[low]<=nums[mid] && nums[mid]>=nums[high]) {
                res=Math.min(res,nums[low]);
                low=mid+1;
            } else {
                res=Math.min(res,nums[mid]);
                high=mid-1;
            }
        }

        return res;
    }
}