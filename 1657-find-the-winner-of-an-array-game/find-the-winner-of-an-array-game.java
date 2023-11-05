class Solution {
    public int getWinner(int[] arr, int k) {
        int n=arr.length;
        int max=arr[0];
        int win=0;

        for (int i=1;i<n;i++)
        {
            if (arr[i]>max)
            {
                max=arr[i];
                win=0;
            }

            if (++win==k)
                return max;
        }

        return max;
    }
}