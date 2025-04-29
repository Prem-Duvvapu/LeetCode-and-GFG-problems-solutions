class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n=nums.length;
        long res=0;
        int left=0;
        int right=0;
        int maxVal=0;
        int maxValFreq=0;

        for (int val: nums)
            maxVal=Math.max(maxVal,val);

        while (right<n) {
            if (nums[right]==maxVal)
                maxValFreq++;

            while (maxValFreq==k) {
                res+=((long)n-right);

                if (nums[left]==maxVal)
                    maxValFreq--;

                left++;
            }

            right++;
        }

        return res;
    }
}