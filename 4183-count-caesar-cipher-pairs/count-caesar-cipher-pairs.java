class Solution {
    public long countPairs(String[] words) {
        int n = words.length;
        Map<String,Integer> map = new HashMap<>();
        long res = 0;

        for (int i=0;i<n;i++) {
            int firstCharDiff = 'z' - words[i].charAt(0);
            StringBuilder newStr = new StringBuilder();
            newStr.append('z');

            for (int j = 1; j < words[i].length(); j++) {
                char shiftedChar = (char) (
                    ((words[i].charAt(j) - 'a' + firstCharDiff) % 26) + 'a'
                );
                newStr.append(shiftedChar);
            }

            String key = newStr.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (long freq: map.values()) {
            long curr = (freq * (freq-1))/2;
            res += curr;
        }

        return res;
    }
}