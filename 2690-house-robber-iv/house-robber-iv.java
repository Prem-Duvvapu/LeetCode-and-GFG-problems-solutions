class Solution {
    public int minCapability(int[] nums, int k) {
        int n=nums.length;

        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;

        for (int i=0;i<n;i++) {
            low=Math.min(low,nums[i]);
            high=Math.max(high,nums[i]);
        }

        int res=high;
        while (low<=high) {
            int mid=low+(high-low)/2;
            int currCnt=0;
            int currRes=0;
            for (int i=0;i<n;i++) {
                if (nums[i]<=mid) {
                    currCnt++;
                    currRes=Math.max(currRes,nums[i]);
                    i++;
                }
            }

            if (currCnt>=k) {
                res=currRes;
                high=currRes-1;
            } else {
                low=mid+1;
            }
        }

        return res;
    }
}