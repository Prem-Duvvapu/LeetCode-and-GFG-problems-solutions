class Solution {
    public char findTheDifference(String s, String t) {
        int[] cnt=new int[26];

        for (char ch: t.toCharArray())
            cnt[ch-'a']++;

        for (char ch: s.toCharArray())
            cnt[ch-'a']--;

        for (int i=0;i<26;i++)
            if (cnt[i]==1)
                return (char)('a'+i);

        return ' ';
    }
}