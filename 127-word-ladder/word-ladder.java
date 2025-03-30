class Node {
    String word;
    int level;

    Node(String word,int level) {
        this.word=word;
        this.level=level;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n=wordList.size();
        Set<String> set=new HashSet<>();
        Queue<Node> q=new LinkedList<>();

        for (String word: wordList)
            set.add(word);

        q.add(new Node(beginWord,0));

        while (!q.isEmpty()) {
            Node currNode=q.poll();
            String currWord=currNode.word;
            int currLevel=currNode.level;

            if (currWord.equals(endWord))
                return currLevel+1;

            for (int i=0;i<currWord.length();i++) {
                StringBuilder temp=new StringBuilder(currWord);

                for (char ch='a';ch<='z';ch++) {
                    temp.setCharAt(i,ch);

                    if (set.contains(temp.toString())) {
                        set.remove(temp.toString());
                        q.add(new Node(temp.toString(),currLevel+1));
                    }
                }
            }
        }

        return 0;
    }
}