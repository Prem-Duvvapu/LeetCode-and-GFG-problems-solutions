//brute force
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n=arr.length;
        int res=k;

        int low=0;
        int high=n-1;
        int missingCnt=0;
        
        while (low<=high) {
            int mid=low+(high-low)/2;

            missingCnt=(arr[mid]-mid-1);

            if (missingCnt<k)
                low=mid+1;
            else
                high=mid-1;
        }

        // missingCnt=(arr[high]-high-1);
        // res=arr[high]+(k-missingCnt);
        // =>res=arr[high]+k-arr[high]+high+1;
        // =>res=high+1+k;
        // =>res=low+k;
        return low+k;
    }
}