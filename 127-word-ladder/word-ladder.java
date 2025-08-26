class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        int n = beginWord.length();
        int res = 1;

        set.add(beginWord);
        q.add(beginWord);

        while (!q.isEmpty()) {
            int qlen = q.size();

            while (qlen-- > 0) {
                String curr = q.poll();

                if (curr.equals(endWord))
                    return res;

                StringBuilder newWord = new StringBuilder(curr);
                for (int i=0;i<n;i++) {
                    char originalChar = newWord.charAt(i);

                    for (char ch='a';ch<='z';ch++) {
                        newWord.setCharAt(i,ch);

                        if (wordSet.contains(newWord.toString()) && !set.contains(newWord.toString())) {
                            set.add(newWord.toString());
                            q.add(newWord.toString());
                        }
                    }

                    newWord.setCharAt(i,originalChar);
                }
            }

            res++;
        }

        return 0;
    }
}