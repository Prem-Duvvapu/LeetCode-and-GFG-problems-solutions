class Solution {
    public int removeDuplicates(int[] nums) {
        int pos=0;

        for (int i=0;i<nums.length;i++)
            if (i<2 || nums[i]>nums[pos-2])
                nums[pos++]=nums[i];

        return pos;
    }
}