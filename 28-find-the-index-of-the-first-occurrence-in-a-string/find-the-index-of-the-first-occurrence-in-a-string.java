//kmp algorithm
class Solution {
    public int strStr(String haystack, String needle) {
        int n=haystack.length();
        int m=needle.length();
        int res=-1;
        int[] lps=new int[m];
        lps[0]=0;
        int i=1;
        int currLength=0;

        while (i<m) {
            if (needle.charAt(i)==needle.charAt(currLength))  {
                currLength++;
                lps[i]=currLength;
                i++;
            } else {
                if (currLength==0) {
                    lps[i]=currLength;
                    i++;
                } else {
                    currLength--;
                    currLength=lps[currLength];
                }
            }
        }

        System.out.println(Arrays.toString(lps));
        i=0;
        int j=0;

        while (i<n && j<m) {
            if (haystack.charAt(i)==needle.charAt(j)) {
                i++;
                j++;
            } else if (j==0) {
                i++;
            } else {
                j=lps[j-1];
            }
        }

        if (j>=m)
            res=i-m;

        return res;
    }
}