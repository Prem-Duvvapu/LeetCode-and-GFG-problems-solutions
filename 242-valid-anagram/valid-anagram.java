class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length())
            return false;

        int n=s.length();
        int[] freq=new int[26];

        for (int i=0;i<n;i++) {
            char ch=s.charAt(i);
            freq[ch-'a']++;
        }

        for (int i=0;i<n;i++) {
            char ch=t.charAt(i);
            freq[ch-'a']--;
        }

        for (int i=0;i<26;i++)
            if (freq[i]!=0)
                return false;

        return true;
    }
}