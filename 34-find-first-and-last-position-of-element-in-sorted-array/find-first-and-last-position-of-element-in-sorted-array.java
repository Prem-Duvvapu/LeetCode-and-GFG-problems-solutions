class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res=new int[2];
        int start=bSearch(target,nums,0);
        if (start==nums.length || nums[start]!=target)
        {
            res[0]=-1;
            res[1]=-1;
            return res;
        }
        int end=bSearch(target+1,nums,start)-1;
        res[0]=start;
        res[1]=end;
        return res;
    }


        private int bSearch(int target,int[] nums,int left)
        {
            int right=nums.length-1;
            while (left<=right)
            {
                int mid=(left+right)/2;
                if (nums[mid]<target)
                {
                    left=mid+1;
                }
                else
                {
                    right=mid-1;
                }
            }
            return left;
        }
        
        
}