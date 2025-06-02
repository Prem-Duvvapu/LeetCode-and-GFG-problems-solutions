class Solution {
    public boolean checkValidString(String s) {
        int maxVal=0;
        int minVal=0;

        for (char ch: s.toCharArray()) {
            if (ch=='(')  {
                maxVal++;
                minVal++;
            } else if (ch==')') {
                maxVal--;
                minVal--;
            } else {
                maxVal++;
                minVal--;
            }

            minVal=Math.max(0,minVal);

            if (maxVal<0) //no corresponding open brackets possible for closed brackets
                return false;
        }

        if (minVal>0) //no corresponding close brackets possible for opened brackets
            return false;

        return true; 
    }
}