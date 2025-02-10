class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int ind=-1;

        //1. find the index where a[i]<a[i+1];
        for (int i=n-2;i>=0;i--) {
            if (nums[i]<nums[i+1]) {
                ind=i;
                break;
            }
        }

        //edge case - when nums in the last permutation
        if (ind==-1) {
            reverse(nums,0,n-1);
            return;
        }

        //2. find the next largest elements and do swap it with nums[ind]
        for (int j=n-1;j>ind;j--) {
            if (nums[j]>nums[ind]) {
                swap(nums,ind,j);
                break;
            }
        }

        //3. sort the remaining elements after ind. All the remaining already exists in descending order. So, just reverse them.
        reverse(nums,ind+1,n-1);
    }

    public void swap(int[] nums,int i,int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public void reverse(int[] nums,int start,int end) {
        while (start<end) {
            swap(nums,start,end);
            start++;
            end--;
        }
    }
}