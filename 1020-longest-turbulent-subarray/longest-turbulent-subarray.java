
class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int maxLength = 1;
        int left = 0;

        for (int right = 1; right < n; right++) {
            int comparison = Integer.compare(arr[right - 1], arr[right]);

            if (comparison == 0) {
                left = right;
            } else if (right > 1) {
                int previousComparison = Integer.compare(
                    arr[right - 2], arr[right - 1]
                );

                if (comparison == previousComparison) {
                    left = right - 1;
                }
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}