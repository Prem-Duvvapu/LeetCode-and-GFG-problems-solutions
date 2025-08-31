class Solution {
    public int score(String[] cards, char x) {
        int n = cards.length;
        Map<String,Integer> first = new HashMap<>();
        Map<String,Integer> second = new HashMap<>();
        int sameCnt = 0;

        for (String card: cards) {
            char ch1 = card.charAt(0);
            char ch2 = card.charAt(1);

            if (ch1 == x && ch2 == x) {
                sameCnt++;
            } else if (ch1 == x) {
                first.put(card,first.getOrDefault(card,0)+1);
            } else if (ch2 == x) {
                second.put(card,second.getOrDefault(card,0)+1);
            }
        }

        int total1 = 0;
        int maxFreq1 = 0;
        for (int val: first.values())  {
            total1 += val;
            maxFreq1 = Math.max(maxFreq1, val);
        }

        int pairsCnt1 = Math.min(total1/2, total1 - maxFreq1);
        int rem1 = total1 - 2*pairsCnt1;

        int total2 = 0;
        int maxFreq2 = 0;
        for (int val: second.values()) {
            total2 += val;
            maxFreq2 = Math.max(maxFreq2, val);
        }

        int pairsCnt2 = Math.min(total2/2, total2 - maxFreq2);
        int rem2 = total2 - 2*pairsCnt2;

        int pairsCnt3 = Math.min(sameCnt, rem1 + rem2);
        int res = pairsCnt1 + pairsCnt2 + pairsCnt3;

        // edge case
        res += Math.min((sameCnt - pairsCnt3)/2, pairsCnt1 + pairsCnt2);

        return res;
    }
}