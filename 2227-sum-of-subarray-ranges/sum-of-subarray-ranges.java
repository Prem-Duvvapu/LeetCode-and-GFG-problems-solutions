//brute
//Time: O(n^2)
//Space: O(1)
class Solution {
    public long subArrayRanges(int[] nums) {
        int n=nums.length;
        long sum=0;

        for (int i=0;i<n;i++) {
            int minVal=Integer.MAX_VALUE;
            int maxVal=Integer.MIN_VALUE;
            
            for (int j=i;j<n;j++) {
                minVal=Math.min(minVal,nums[j]);
                maxVal=Math.max(maxVal,nums[j]);

                sum+=(maxVal-minVal);
            }
        }
        
        return sum;
    }
}