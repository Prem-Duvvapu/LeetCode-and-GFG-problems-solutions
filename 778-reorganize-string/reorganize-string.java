class Solution {
    public String reorganizeString(String s) {
        int n=s.length();
        int[] cnt=new int[26];
        for (char ch: s.toCharArray())
            cnt[ch-'a']++;

        StringBuilder sb=new StringBuilder();
        int last=-1;
        while (n-- > 0)
        {
            int index=-1;
            int maxi=0;
            for (int i=0;i<26;i++)
            {
                if (i!=last && cnt[i]>maxi)
                {
                    index=i;
                    maxi=cnt[i];
                }
            }

            if (index==-1)
                return "";

            sb.append((char)('a'+index));
            cnt[index]--;
            last=index;
        }

        return sb.toString();
    }
}