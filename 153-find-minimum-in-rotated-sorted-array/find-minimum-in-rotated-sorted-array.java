class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        int res=5001;

        while (low<=high) {
            int mid=low+(high-low)/2;
            res=Math.min(res,nums[mid]);

            if (nums[low]<=nums[mid]) {
                res=Math.min(res,nums[low]);
                low=mid+1;
            } else {
                res=Math.min(res,nums[mid+1]);
                high=mid-1;
            }
        }

        return res;
    }
}