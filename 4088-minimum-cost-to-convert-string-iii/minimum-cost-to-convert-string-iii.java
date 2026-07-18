class Solution {
    public int minCost(String source, String target, List<List<String>> rules, int[] costs) {
        if (source.length() != target.length()) {
            return -1;
        }

        int n = source.length();
        int res = 0;
        int[] dp = new int[n+1];
        Arrays.fill(dp, (int)1e8);
        dp[n] = 0;

        for (int i=n-1;i>=0;i--) {
            if (source.charAt(i) == target.charAt(i)) {
                dp[i] = dp[i+1];
            }

            for (int j=0;j<rules.size();j++) {
                List<String> rule = rules.get(j);
                String pat = rule.get(0);
                String rep = rule.get(1);
                boolean sourcePatternMatched = true;
                boolean replacementTargetMatched = true;

                if (pat.length() > (n - i)) {
                    continue;
                }

                for (int k=0;k<pat.length();k++) {
                    if (pat.charAt(k) != '*' && source.charAt(i+k) != pat.charAt(k)) {
                        sourcePatternMatched = false;
                        break;
                    }
                }

                if (!sourcePatternMatched) {
                    continue;
                }

                for (int k=0;k<rep.length();k++) {
                    if (rep.charAt(k) != target.charAt(i+k)) {
                        replacementTargetMatched = false;
                        break;
                    }
                }

                if (!replacementTargetMatched) {
                    continue;
                }

                int ruleCost = costs[j];
                for (char ch: pat.toCharArray()) {
                    if (ch == '*') {
                        ruleCost++;
                    }
                }

                dp[i] = Math.min(dp[i], ruleCost+dp[i+pat.length()]);
            }
        }
        
        return (dp[0] == (int)1e8) ? -1 : dp[0];
    }
}