//merge sort

class Solution {
    public int[] sortArray(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n];
        for (int i=0;i<n;i++)
            arr[i]=nums[i];
        mergeSort(arr,0,n-1);
        return arr;
    }

    private void mergeSort(int[] nums,int left,int right)
    {
        if (left<right)
        {
            int mid=left+(right-left)/2;
            mergeSort(nums,left,mid);
            mergeSort(nums,mid+1,right);
            merge(nums,left,mid,right);
        }
    }

    private void merge(int[] nums,int left,int mid,int right)
    {
        int[] a=new int[right-left+1];
        int i1=left;
        int i2=mid+1;
        int k=0;

        while (i1<=mid && i2<=right)
        {
            if (nums[i1]<nums[i2])
                a[k++]=nums[i1++];
            else
                a[k++]=nums[i2++];
        }

        while (i1<=mid)
            a[k++]=nums[i1++];

        while (i2<=right)
            a[k++]=nums[i2++];

        for (int i=0,j=left;i<a.length;i++,j++)
            nums[j]=a[i];
    }
}