//Appraoch-2 -> Sorting
class Solution {
    public int minDeletions(String s) {
        int n=s.length();
        int res=0;
        int[] freq=new int[26];

        for (char ch: s.toCharArray())
            freq[ch-'a']++;

        Arrays.sort(freq);

        for (int i=24;i>=0;i--)
        {
            int curr=freq[i];

            if (freq[i]>=freq[i+1])
                freq[i]=Math.max(0,freq[i+1]-1);

            res+=(curr-freq[i]);
        }

        return res;
    }
}