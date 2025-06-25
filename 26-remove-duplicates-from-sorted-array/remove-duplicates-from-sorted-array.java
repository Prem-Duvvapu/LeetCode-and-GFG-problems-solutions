class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;

        int i=1;
        int j=1;

        while (j<n) {
            if (nums[j]!=nums[j-1]) {
                nums[i]=nums[j];
                i++;
            }
            j++;
        }

        return i;
    }
}