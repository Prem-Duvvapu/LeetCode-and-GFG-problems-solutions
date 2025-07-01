class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n-2;
        int j = n-1;

        while (i >= 0) {
            if (nums[i] < nums[i+1])
                break;

            i--;
        }

        while (i>=0 && j > i) {
            if (nums[j] > nums[i])
                break;

            j--;
        }

        if (i>=0)
            swap(nums,i,j);
            
        reverse(nums,i+1,n-1);
    }

    public void swap(int[] a,int i,int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void reverse(int[] a,int low,int high) {
        while (low < high) {
            swap(a,low,high);
            low++;
            high--;
        }
    }
}