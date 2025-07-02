class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        if (n <= 1)
            return n;

        int maxConsecutive = 0;
        int currConsecutive = 0;
        Set<Integer> set = new HashSet<>();

        for (int val: nums)
            set.add(val);

        for (int e: set) {
            int prevElement = e-1;
            int nextElement = e+1;

            if (set.contains(prevElement))
                continue;

            currConsecutive = 1;
            while (set.contains(nextElement)) {
                currConsecutive++;
                nextElement += 1;
            }

            maxConsecutive = Math.max(maxConsecutive, currConsecutive);
        }
        
        return maxConsecutive;
    }
}