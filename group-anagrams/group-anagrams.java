class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result=new ArrayList<>();

        if (strs.length==1)
        {
            result.add(Arrays.asList(strs));
            return result;
        }

        Map<String,ArrayList<String>> anagrams=new HashMap<>();

        for (String s: strs)
        {
            String key=countChar(s);
            anagrams.putIfAbsent(key,new ArrayList<>());
            anagrams.get(key).add(s);
        }

        result=new ArrayList<>(anagrams.values());
        return result;
    }

    private String countChar(String s)
    {
        int[] count=new int[26];//a to z
        for (int i=0;i<s.length();i++)
            count[s.charAt(i)-'a']++;//counting each character count in the String s

        StringBuilder sb=new StringBuilder();
        for (int i=0;i<26;i++)
            if (count[i]!=0)
                sb.append((char)('a'+i)).append(count[i]);

        return sb.toString();
    }
}