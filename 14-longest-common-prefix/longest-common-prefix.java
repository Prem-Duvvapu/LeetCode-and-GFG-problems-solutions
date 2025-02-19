class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n=strs.length;
        String res=strs[0];

        for (int i=1;i<n;i++) {
            int j=0; //res pointer
            int k=0; //strs[i] pointer

            while (j<res.length() && k<strs[i].length()) {
                if (res.charAt(j)!=strs[i].charAt(k)) {
                    if (j==0)
                        return "";
                    
                    res=res.substring(0,j);
                    break;
                }

                j++;
                k++;
            }

            if (k<res.length())
                res=res.substring(0,k);

        }

        return res;
    }
}