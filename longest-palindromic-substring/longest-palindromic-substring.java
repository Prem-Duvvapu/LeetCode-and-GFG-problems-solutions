class Solution {
    public String longestPalindrome(String s) {
        int start=0;
        int end=0;

        //Consider the current index of the string as centre index of palindrome and then check left index and right index until they are not equal or they reach out of bounds. Update the start and end indexes if current palindrome length is greater than previous palindrome length.
        for (int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            int left=i;
            int right=i;

            while (left>=0 && s.charAt(left)==ch)
                left--;

            while (right<s.length() && s.charAt(right)==ch)
                right++;

            while (left>=0 && right<s.length())
            {
                if (s.charAt(left)!=s.charAt(right))
                    break;

                left--;
                right++;
            }

            left++;
            right--;
            if ((right-left+1)>(end-start+1))
            {
                start=left;
                end=right;
            }
        }

        return s.substring(start,end+1);
    }
}

//TC - O(n^2)
//SC - O(1)