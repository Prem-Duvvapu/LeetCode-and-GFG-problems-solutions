class Solution {
    int cnt=0;
    public int reversePairs(int[] nums) {
        int n=nums.length;
        mergeSort(nums,0,n-1);
        return cnt;
    }

    void mergeSort(int arr[], int l, int r) {
        if (l<r) {
            int mid=l+(r-l)/2;
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            countPairs(arr,l,mid,r);
            merge(arr,l,mid,r);
        }
    }

    void countPairs(int[] arr,int low,int mid,int high) {
        int right=mid+1;
        for (int left=low;left<=mid;left++) {
            while (right<=high && (long)arr[left] > 2*(long)arr[right])
                right++;
            cnt+=(right-(mid+1));
        }
    }
    
    void merge(int[] arr,int l,int mid,int r) {
        int n=mid-l+1;
        int m=r-mid;
        
        int[] a=new int[n];
        int[] b=new int[m];
        
        for (int i=0;i<n;i++)
            a[i]=arr[l+i];
            
        for (int i=0;i<m;i++)
            b[i]=arr[mid+1+i];
            
        int i=0,j=0,k=l;
        
        while (i<n && j<m) {
            if (a[i]<=b[j]) {
                arr[k]=a[i];
                i++;
            } else {
                arr[k]=b[j];
                j++;
            }
            k++;
        }
        
        while (i<n)
            arr[k++]=a[i++];
            
        while (j<m)
            arr[k++]=b[j++];
    }
}