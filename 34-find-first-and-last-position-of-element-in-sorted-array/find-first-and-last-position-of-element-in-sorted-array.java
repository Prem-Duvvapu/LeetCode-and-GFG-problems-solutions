class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int[] res=new int[2];

        res[0]=lowerBound(0,n-1,nums,target);
        res[1]=upperBound(0,n-1,nums,target);

        return res;
    }

    public int lowerBound(int low,int high,int[] arr,int target) {
        int res=-1;

        while (low<=high) {
            int mid=low+(high-low)/2;

            if (arr[mid]>=target) {
                res=mid;
                high=mid-1;
            } else {
                low=mid+1;
            }
        }

        if (res!=-1 && arr[res]==target)
            return res;

        return -1;
    }

    public int upperBound(int low,int high,int[] arr,int target) {
        int res=arr.length;

        while (low<=high) {
            int mid=low+(high-low)/2;

            if (arr[mid]>target) {
                res=mid;
                high=mid-1;
            } else {
                low=mid+1;
            }
        }

        if (arr.length==0)
            return -1;

        if (res==0)
            return -1;

        if (arr[res-1]==target)
            return res-1;

        return -1;
    }
}