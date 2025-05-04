class Solution {
    public int beautySum(String s) {
        int n=s.length();
        int totalSum=0;
        int[] freq=new int[26];
        int minFreq=Integer.MAX_VALUE;
        int maxFreq=Integer.MIN_VALUE;

        for (int i=0;i<n;i++) {
            Arrays.fill(freq,0);

            for (int j=i;j<n;j++) {
                int pos=s.charAt(j)-'a';
                freq[pos]++;

                minFreq=Integer.MAX_VALUE;
                maxFreq=Integer.MIN_VALUE;

                for (int k=0;k<26;k++) {
                    if (freq[k]!=0 && freq[k]<minFreq)
                        minFreq=Math.min(minFreq,freq[k]);
                    
                    maxFreq=Math.max(maxFreq,freq[k]);
                }

                totalSum+=(maxFreq-minFreq);
            }
        }

        return totalSum;
    }
}