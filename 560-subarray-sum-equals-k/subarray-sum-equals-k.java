class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int res=0;
        int[] prefix=new int[n];
        prefix[0]=nums[0];
        int currSum=0;

        for (int i=1;i<n;i++)
            prefix[i]=prefix[i-1]+nums[i];

        for (int i=0;i<n;i++) {
            for (int j=i;j<n;j++) {
                if (i==0) {
                    if (prefix[j]==k)
                        res++;
                    continue;
                }

                if (prefix[j]-prefix[i-1]==k)
                    res++;
            }
        }

        return res;
    }
}