//Greedy approach

class Solution {
    public int minDeletions(String s) {
        Set<Integer> set=new HashSet<>();
        int[] cnt=new int[26];
        int res=0;

        for (char ch: s.toCharArray())
            cnt[ch-'a']++;

        for (int i=0;i<26;i++)
        {
            while (cnt[i]>0 && !set.add(cnt[i]))
            {
                cnt[i]--;
                res++;
            }
        }

        return res;
    }
}