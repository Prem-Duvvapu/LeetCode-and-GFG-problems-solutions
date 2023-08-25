class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int j=0;
        int i=0;

        while (i<str2.length() && j<str1.length())   
        {
            int a=str2.charAt(i)-'a';
            while (j<str1.length())
            {
                int b=str1.charAt(j)-'a';
                j++;
                if (b==a || (b+1)%26==a)
                  
                  i++;  break;
            }
        }

        return (i==str2.length());
    }
}