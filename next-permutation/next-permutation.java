class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length==1)
            return;

        int i=nums.length-2;
        while (i>=0)
        {
            if (nums[i]<nums[i+1])
                break;
            i--;
        }

        int j=nums.length-1;
        while (j>=0 && i!=-1)
        {
            if (nums[j]>nums[i])
                break;
            j--;
        }

        if (i>=0 && j>=0)
        {
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }

        reverse(nums,i+1,nums.length-1);
    }

    private void reverse(int[] nums,int left,int right)
    {
        while (left<right)
        {
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
}