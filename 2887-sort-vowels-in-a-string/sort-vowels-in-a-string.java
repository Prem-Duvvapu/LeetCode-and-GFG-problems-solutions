class Solution {
    public String sortVowels(String s) {
        StringBuilder sb=new StringBuilder();
        List<Character> list=new ArrayList<>();
        String vowels="AEIOUaeiou";
        
        for (char ch: s.toCharArray())
            if (vowels.indexOf(ch)!=-1)
                list.add(ch);
        
        int k=0;
        Collections.sort(list);
        for (char ch: s.toCharArray())
        {
            if (vowels.indexOf(ch)!=-1)
                sb.append(list.get(k++));
            else
                sb.append(ch);
        }
        
        return sb.toString();
    }
}