class Solution {
    public long largestPerimeter(int[] nums) {
        int n=nums.length;
        long res=-1;
        long[] prefix=new long[n];

        Arrays.sort(nums);
        prefix[0]=nums[0];

        for (int i=1;i<n;i++) {
            prefix[i]=nums[i]+prefix[i-1];
        }

        for (int i=n-1;i>1;i--) {
            if (nums[i]<prefix[i-1])
                return prefix[i];
        }

        return -1;
    }
}