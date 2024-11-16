class Pair {
    String word;
    int level;

    Pair(String _word, int _level) {
        word = _word;
        level = _level;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for (String word: wordList)
            set.add(word);
        System.out.println(set);

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(beginWord,0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            String currWord = curr.word;
            int currLevel = curr.level;

            if (currWord.equals(endWord))
                return currLevel+1;
            
            for (int i=0; i<currWord.length(); i++) {
                StringBuilder temp = new StringBuilder(currWord);
                for (char ch='a'; ch<='z'; ch++) {
                    temp.setCharAt(i, ch);
                    if (set.contains(temp.toString())) {
                        // System.out.println(temp);
                        set.remove(temp.toString());
                        q.add(new Pair(temp.toString(), currLevel+1));
                    }
                }
            }
        }

        return 0;
    }
}