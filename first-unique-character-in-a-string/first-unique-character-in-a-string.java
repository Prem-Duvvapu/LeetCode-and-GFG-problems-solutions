class Solution {
    public int firstUniqChar(String s) {
        int[] charCount=new int[26];

        for (char ch:s.toCharArray())
            charCount[ch-'a']++;

        for (int i=0;i<s.length();i++)
            if (charCount[s.charAt(i)-'a']==1)
                return i;
        
        return -1;
    }
}