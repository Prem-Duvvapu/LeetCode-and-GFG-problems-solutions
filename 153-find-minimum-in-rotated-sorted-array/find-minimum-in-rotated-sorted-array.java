class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        int res=Integer.MAX_VALUE;

        while (low<=high) {
            int mid=low+(high-low)/2;

            if (nums[low]<=nums[mid] && nums[mid]<=nums[high])
                res=Math.min(res,nums[low]);

            res=Math.min(res,nums[mid]);
            //if left half is sorted
            if (nums[low]<=nums[mid] && nums[mid]>=nums[high]) {
                low=mid+1;
            } else {
                high=mid-1;
            }
        }

        return res;
    }
}