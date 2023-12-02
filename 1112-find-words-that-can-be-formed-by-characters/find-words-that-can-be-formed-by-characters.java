class Solution {
    public int countCharacters(String[] words, String chars) {
        int res=0;
        int[] cnt=new int[26];
        for (char ch: chars.toCharArray())
            cnt[ch-'a']++;

        for (String word: words)
        {
            int[] curr=new int[26];
            boolean flag=true;
            for (char ch: word.toCharArray())
            {
                curr[ch-'a']++;
                if (curr[ch-'a']>cnt[ch-'a'])
                {
                    flag=false;
                    break;
                }
            }
            if (flag)
                res+=word.length();
        }

        return res;
    }
}