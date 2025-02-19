class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n=s.length();

        int[] sTot=new int[256];
        int[] tTos=new int[256];

        Arrays.fill(sTot,-1);
        Arrays.fill(tTos,-1);

        for (int i=0;i<n;i++) {
            char sChar=s.charAt(i);
            char tChar=t.charAt(i);

            //s to t checking
            if (sTot[sChar]!=-1 && sTot[sChar]!=tChar)
                return false;
            else
                sTot[sChar]=tChar;

            //t to s checking
            if (tTos[tChar]!=-1 && tTos[tChar]!=sChar)
                return false;
            else
                tTos[tChar]=sChar;
        }

        return true;
    }
}