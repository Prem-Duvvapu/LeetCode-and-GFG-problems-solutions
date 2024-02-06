class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();

        for (String currWord: strs) {
            char[] arr=currWord.toCharArray();
            Arrays.sort(arr);
            String sortedWord=new String(arr);

            if (map.containsKey(sortedWord))
                res.get(map.get(sortedWord)).add(currWord);
            else {
                map.put(sortedWord,res.size());
                res.add(new ArrayList<>(Arrays.asList(currWord)));
            }
        }

        return res;
    }
}