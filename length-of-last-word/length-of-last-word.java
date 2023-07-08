class Solution {
    public int lengthOfLastWord(String s) {
        int right=s.length()-1;
        int left=0;

        while (right>=0 & s.charAt(right)==' ')
            right--;

        left=right;
        while (left>=0 && s.charAt(left)!=' ')
            left--;

        return (right-left);
    }
}