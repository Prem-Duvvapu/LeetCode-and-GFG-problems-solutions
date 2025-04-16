class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        long pairs = 0;
        int left = 0;
        long res = 0;

        for (int right = 0; right < n; right++) {
            int num = nums[right];
            int freq = map.getOrDefault(num, 0);
            pairs -= (long) freq * (freq - 1) / 2;
            freq++;
            pairs += (long) freq * (freq - 1) / 2;
            map.put(num, freq);

            while (left <= right && pairs >= k) {
                res += (n - right);  
                int leftNum = nums[left];
                int leftFreq = map.get(leftNum);
                pairs -= (long) leftFreq * (leftFreq - 1) / 2;
                leftFreq--;
                pairs += (long) leftFreq * (leftFreq - 1) / 2;

                if (leftFreq == 0)
                    map.remove(leftNum);
                else
                    map.put(leftNum, leftFreq);

                left++;
            }
        }

        return res;
    }
}
