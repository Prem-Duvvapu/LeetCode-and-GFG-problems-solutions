class Solution {
    public boolean makeEqual(String[] words) {
        int n=words.length;
        int[] cnt=new int[26];
        int total=0;

        for (String curr: words) {
            total+=curr.length();
            for (char ch: curr.toCharArray())
                cnt[ch-'a']++;
        }

        if (total%n!=0)
            return false;

        for (int i=0;i<26;i++)
            if (cnt[i]%n!=0)
                return false;

        return true;
    }
}