class Solution {
    public int reversePairs(int[] nums) {
        int n=nums.length;
        return mergeSort(0,n-1,nums);
    }

    public int mergeSort(int low,int high,int[] arr) {
        int cnt = 0;
        if (low<high) {
            int mid = low+(high-low)/2;
            cnt += mergeSort(low,mid,arr);
            cnt += mergeSort(mid+1,high,arr);
            cnt += countReversePairs(low,mid,high,arr);
            merge(low,mid,high,arr);
        }

        return cnt;
    }

    public int countReversePairs(int low,int mid,int high,int[] arr) {
        int i = low;
        int j = mid+1;
        int currCnt = 0;

        while (i<=mid && j<=high) {
            if ((long)arr[i] > 2*(long)arr[j]) {
                currCnt += (mid-i+1);
                j++;
            } else {
                i++;
            }
        }

        return currCnt;
    }
    
    public void merge(int low,int mid,int high,int[] arr) {
        int[] a = new int[high-low+1];
        
        int i = low;
        int j = mid+1;
        int pos = 0;
        
        while (i<=mid && j<=high) {
            if (arr[i]<=arr[j])
                a[pos++] = arr[i++];
            else
                a[pos++] = arr[j++];
        }
        
        while (i<=mid)
            a[pos++] = arr[i++];
            
        while (j<=high)
            a[pos++] = arr[j++];
            
        for (pos=0;pos<a.length;pos++)
            arr[low+pos]=a[pos];
    }
}