class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, (a,b) -> Integer.compare(a.length(),b.length()));
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int maxChain = 0;

        for (int curr=0;curr<n;curr++) {
            for (int prev=0;prev<curr;prev++) {
                if (isPredecessor(words[curr], words[prev])) {
                    dp[curr] = Math.max(dp[curr], 1 + dp[prev]);
                }
            }

            maxChain = Math.max(maxChain, dp[curr]);
        }

        return maxChain;
    }

    public boolean isPredecessor(String longer, String shorter) {
        if (longer.length() - shorter.length() != 1) {
            return false;
        }

        int i = 0;
        int j = 0;
        while (i < longer.length() && j < shorter.length()) {
            if (longer.charAt(i) == shorter.charAt(j)) {
                j++;
            }

            i++;
        }

        return (j == shorter.length());
    }
}