class Solution {
    public List<Integer> partitionLabels(String s) {
        int n=s.length();
        List<Integer> res=new ArrayList<>();
        int maxIndex=-1;
        int[] lastOccurence=new int[26];
        int last=-1;

        for (int i=0;i<26;i++)
            lastOccurence[i]=-1;

        for (int i=0;i<n;i++) {
            char ch=s.charAt(i);
            int index=ch-'a';
            lastOccurence[index]=i;
        }

        for (int i=0;i<n;i++) {
            char ch=s.charAt(i);
            int index=ch-'a';
            maxIndex=Math.max(maxIndex,lastOccurence[index]);

            if (i==maxIndex) {
                res.add(i-last);
                last=i;
                maxIndex=-1;
            }
        }

        return res;
    }
}