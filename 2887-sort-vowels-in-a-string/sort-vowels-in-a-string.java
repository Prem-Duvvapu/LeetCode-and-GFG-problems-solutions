class Solution {
    public String sortVowels(String s) {
        StringBuilder sb=new StringBuilder();
        List<Character> list=new ArrayList<>();
        
        for (char ch: s.toCharArray())
            if (ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U' || ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
                    list.add(ch);
        
        int k=0;
        Collections.sort(list);
        for (char ch: s.toCharArray())
        {
            if (ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U' || ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
                    sb.append(list.get(k++));
            else
                    sb.append(ch);
        }
        
        return sb.toString();
    }
}