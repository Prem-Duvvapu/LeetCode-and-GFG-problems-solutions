class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int currIndex=0;

        for (int i=0;i<n;i++)
            if (nums[i]!=0)
                nums[currIndex++]=nums[i];

        while (currIndex<n)
            nums[currIndex++]=0;
    }
}