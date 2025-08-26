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

                for (int i=0;i<n;i++) {
                    for (char ch='a';ch<='z';ch++) {
                        String newWord = curr.substring(0,i)+ch+curr.substring(i+1,n);

                        if (wordSet.contains(newWord) && !set.contains(newWord)) {
                            set.add(newWord);
                            q.add(newWord);
                        }
                    }
                }
            }

            res++;
        }

        return 0;
    }
}