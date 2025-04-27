class Solution {
    public int countSubarrays(int[] nums) {
        int n=nums.length;
        int res=0;

        for (int i=0;i<n-2;i++) {
            int first=nums[i];
            int second=nums[i+1];
            int third=nums[i+2];

            if (second%2==0 && (first+third)==(second/2))
                res++;
        }

        return res;
    }
}