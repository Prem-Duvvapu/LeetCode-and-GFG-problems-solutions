class Solution {
    List<List<String>> res = new ArrayList<>();
    Set<String> set = new HashSet<>();
    Map<String,Integer> map = new HashMap<>();
    int minSteps = -1;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        for (String word: wordList)
            set.add(word);

        int level = 1;
        map.put(beginWord, level);
        q.add(beginWord);
        set.remove(beginWord);

        while (!q.isEmpty()) {
            String curr = q.poll();

            if (curr.equals(endWord)) {
                minSteps = map.get(curr);
                break;
            }

            level = map.get(curr)+1;
            for (int i=0;i<curr.length();i++) {
                for (char ch='a';ch<='z';ch++) {
                    String newWord= curr.substring(0,i)+ch+curr.substring(i+1);
                    if (set.contains(newWord)) {
                        q.add(newWord);
                        map.put(newWord,level);
                        set.remove(newWord);
                    }
                }
            }
        }
        
        List<String> currList = new ArrayList<>();
        currList.add(endWord);
        solve(endWord,currList);

        return res;
    }

    private void solve(String word,List<String> currList) {
        if (currList.size() == minSteps) {
            List<String> temp = new ArrayList<>(currList);
            Collections.reverse(temp);
            res.add(temp);
            return;
        }

        String curr = word;
        for (int i=0;i<curr.length();i++) {
            for (char ch='a';ch<='z';ch++) {
                String newWord= curr.substring(0,i)+ch+curr.substring(i+1);
                if (map.containsKey(newWord) && map.get(newWord) < map.getOrDefault(curr, -1)) {
                    currList.add(newWord);
                    solve(newWord, currList);
                    currList.remove(currList.size()-1);
                }
            }
        }
    }
}