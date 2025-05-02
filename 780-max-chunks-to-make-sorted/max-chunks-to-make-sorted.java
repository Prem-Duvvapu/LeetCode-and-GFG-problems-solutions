class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n=arr.length;
        int currSum=0;

        int expectedSum=0;
        int res=0;
        
        for (int i=0;i<n;i++) {
            expectedSum+=i;
            currSum+=arr[i];

            if (expectedSum==currSum)
                res++;
        }

        return res;
    }
}