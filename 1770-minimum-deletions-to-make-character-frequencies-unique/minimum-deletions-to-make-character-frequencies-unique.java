//Appraoch-1 -> Greedy
class Solution {
    public int minDeletions(String s) {
        int n=s.length();
        int res=0;
        int[] freq=new int[26];
        Set<Integer> set=new HashSet<>();

        for (char ch: s.toCharArray())
            freq[ch-'a']++;

        for (int i=0;i<26;i++)
        {
            while (freq[i]>0 && set.contains(freq[i]))
            {
                freq[i]--;
                res++;
            }

            set.add(freq[i]);
        }

        return res;
    }
}