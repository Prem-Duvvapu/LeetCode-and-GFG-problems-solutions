class Solution {
    public int findValueOfPartition(int[] nums) {
        int n=nums.length;
        int minPartition=Integer.MAX_VALUE;

        Arrays.sort(nums);

        for (int i=0;i<n-1;i++) {
            int currPartition=nums[i+1]-nums[i];
            minPartition=Math.min(minPartition,currPartition);
        }

        return minPartition;
    }
}