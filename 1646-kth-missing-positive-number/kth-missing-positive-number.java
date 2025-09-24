// brute force
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int res = k;

        for (int i=0;i<n;i++) {
            if (arr[i] <= res)
                res++;
        }

        return res;
    }
}