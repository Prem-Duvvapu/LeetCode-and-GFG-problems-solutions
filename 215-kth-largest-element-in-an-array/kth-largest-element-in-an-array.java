class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        k=n-k;
        return quickSelect(nums,0,n-1,k);
    }

    private int quickSelect(int[] nums,int left,int right,int k)
    {
        if (left==right)
            return nums[left];
        
        int index=partition(nums,left,right);
        if (index==k)
            return nums[k];
        else if (index<k)
            return quickSelect(nums,index+1,right,k);
        return quickSelect(nums,left,index-1,k);
    }

    private int partition(int[] nums,int left,int right)
    {
        int i=left-1;
        for (int j=left;j<right;j++)
        {
            if (nums[j]<=nums[right])
            {
                i++;
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }

        i++;
        int temp=nums[i];
        nums[i]=nums[right];
        nums[right]=temp;
        return i;
    }
}