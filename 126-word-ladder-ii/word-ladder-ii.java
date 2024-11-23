class Solution {
    Queue<String> q;
    Map<String,Integer> map;
    List<List<String>> res;
    int level;
    int minSteps;
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        q = new ArrayDeque<>();
        map = new HashMap<>();
        Set<String> set = new HashSet<>();
        res = new ArrayList<>();

        for (String word: wordList)
            set.add(word);


        q.add(beginWord);
        level = 1;
        minSteps = 0;
        map.put(beginWord,level);
        set.remove(beginWord);

        while (!q.isEmpty()) {
            String curr = q.poll();
            if (curr.equals(endWord)) {
                minSteps = map.get(curr);
                break;
            }
            
            level = map.get(curr)+1;
            for (int i=0;i<curr.length();i++) {
                StringBuilder temp = new StringBuilder(curr);
                for (char ch='a';ch<='z';ch++) {
                    temp.setCharAt(i,ch);
                    if (set.contains(temp.toString())) {
                        q.add(temp.toString());
                        map.put(temp.toString(),level);
                        set.remove(temp.toString());
                    }
                }
            }
        }


        List<String> temp = new ArrayList<>();
        temp.add(endWord);
        solve(endWord, temp);

        return res;
    }

    public void solve(String word, List<String> currList) {
        if (currList.size()==minSteps) {
            List<String> newList = new ArrayList<>(currList);
            Collections.reverse(newList);
            res.add(newList);
            return;
        }

        String curr = word;
        for (int i=0;i<curr.length();i++) {
            StringBuilder temp = new StringBuilder(curr);
            for (char ch='a';ch<='z';ch++) {
                temp.setCharAt(i,ch);        
                if (map.containsKey(temp.toString()) && map.get(temp.toString()) < map.getOrDefault(curr,-1)) {
                    currList.add(temp.toString());
                    solve(temp.toString(),currList);
                    currList.remove(currList.size()-1);
                }
            }
        }
    }
}