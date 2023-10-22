class Solution {
    public int minimumSum(int[] nums) {
        int n=nums.length;
        int minSum=Integer.MAX_VALUE;
        int leftMin=nums[0];
        int[] rightMin=new int[n];
        rightMin[n-1]=nums[n-1];
             
        for (int i=n-2;i>=0;i--)
            rightMin[i]=Math.min(nums[i],rightMin[i+1]);
        
        for (int i=1;i<n-1;i++)
        {
            if (nums[i]>leftMin && nums[i]>rightMin[i+1])
                minSum=Math.min(minSum,nums[i]+leftMin+rightMin[i+1]);
            leftMin=Math.min(leftMin,nums[i]);
        }
        
        if (minSum==Integer.MAX_VALUE)
                return -1;
        
        return minSum;
    }
};