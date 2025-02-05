class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int res=solve(nums,k)-solve(nums,k-1);
        return res;
    }

    private int solve(int[] nums,int k) {
        int left=0;
        int right=0;
        int resCnt=0;
        int oddCnt=0;

        while (right < nums.length) {
            if (nums[right]%2==1)
                oddCnt++;

            while (oddCnt > k) {
                if (nums[left]%2==1)
                    oddCnt--;
                left++;
            }

            resCnt+=(right-left+1);
            right++;
        }

        return resCnt;
    }
}