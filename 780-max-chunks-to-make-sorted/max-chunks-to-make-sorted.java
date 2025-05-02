class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n=arr.length;
        int currSum=0;

        int maxVal=0;
        int res=0;
        
        for (int i=0;i<n;i++) {
            maxVal=Math.max(maxVal,arr[i]);
            currSum+=arr[i];

            if (currSum==(maxVal*(maxVal+1))/2 && i==maxVal)
                res++;
        }

        return res;
    }
}