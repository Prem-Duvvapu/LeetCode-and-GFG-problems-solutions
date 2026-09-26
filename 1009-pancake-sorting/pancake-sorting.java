class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();

        for (int size = arr.length; size > 1; size--) {

            // Find index of maximum element in arr[0...size-1]
            int maxIndex = 0;

            for (int i = 1; i < size; i++) {
                if (arr[i] > arr[maxIndex]) {
                    maxIndex = i;
                }
            }

            // Already in correct position
            if (maxIndex == size - 1) {
                continue;
            }

            // Bring maximum element to front
            if (maxIndex != 0) {
                flip(arr, maxIndex + 1);
                res.add(maxIndex + 1);
            }

            // Move maximum element to its correct position
            flip(arr, size);
            res.add(size);
        }

        return res;
    }

    private void flip(int[] arr, int k) {
        int left = 0;
        int right = k - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}