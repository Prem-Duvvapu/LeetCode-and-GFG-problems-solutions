class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int maxIndex=0;

        for (int i=1;i<arr.length;i++)
            if (arr[i]>arr[maxIndex])
                maxIndex=i;

        return maxIndex;
    }
}