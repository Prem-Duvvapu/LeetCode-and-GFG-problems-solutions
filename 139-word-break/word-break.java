class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        Set<String> wordSet = new HashSet<>();
        for (String word: wordDict) {
            wordSet.add(word);
        }

        return solve(0,s,wordSet,dp);
    }

    private boolean solve(int pos,String s,Set<String> wordSet,Boolean[] dp) {
        if (pos == s.length()) {
            return true;
        }

        if (dp[pos] != null) {
            return dp[pos];
        }

        for (int i=pos;i<s.length();i++) {
            if (wordSet.contains(s.substring(pos,i+1))) {
                if (solve(i+1,s,wordSet,dp)) {
                    return dp[pos] = true;
                }
            }
        }

        return dp[pos] = false;
    }
}