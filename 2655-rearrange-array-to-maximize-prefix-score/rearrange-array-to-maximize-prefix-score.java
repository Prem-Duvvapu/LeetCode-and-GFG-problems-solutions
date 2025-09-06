class Solution {
    public int maxScore(int[] nums) {
        int n = nums.length;
        long sum = 0;
        Arrays.sort(nums);
        reverse(nums);

        for (int i=0;i<n;i++) {
            sum += nums[i];
            if (sum <= 0)
                return i;
        }

        return n;
    }

    public void reverse(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;

            low++;
            high--;
        }
    }
}