class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int currLength = 0;
        int[] lastSeen = new int[256];
        Arrays.fill(lastSeen,-1);

        while (right < n) {
            char ch = s.charAt(right);
            if (lastSeen[ch] != -1) {
                left = Math.max(left, lastSeen[ch]+1);
            }

            currLength = (right - left + 1);
            maxLength = Math.max(maxLength, currLength);
            lastSeen[ch] = right;
            right++;
        }

        return maxLength;
    }
}