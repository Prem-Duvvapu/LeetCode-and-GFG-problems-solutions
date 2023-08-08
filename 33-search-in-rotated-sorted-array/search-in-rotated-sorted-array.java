class Solution {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;

        while (left<=right)
        {
            int mid=left+(right-left)/2;

            //if target found at mid position
            if (nums[mid]==target)
                return mid;

            //if left part is sorted
            else if (nums[left]<=nums[mid])
            {
                //if target found at the left part
                if (target>=nums[left] && target<nums[mid])
                    right=mid-1;
                else
                    left=mid+1;
            }
            
            //if right part is sorted
            else
            {
                //if target found at right part
                if (target>nums[mid] && target<=nums[right])
                    left=mid+1;
                else
                    right=mid-1;
            }
        }

        return -1;
    }
}