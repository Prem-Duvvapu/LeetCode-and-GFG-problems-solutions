class Solution {
    public boolean checkValidString(String s) {
        int n=s.length();
        int minVal=0;
        int maxVal=0;

        for (int i=0;i<n;i++) {
            char ch=s.charAt(i);
            if (ch=='(') {
                minVal++;
                maxVal++;
            } else if (ch==')') {
                minVal--;
                maxVal--;
            } else {
                minVal--;
                maxVal++;
            }

            minVal=Math.max(0,minVal);

            if (maxVal<0)
                return false;
        }

        return (minVal==0);
    }
}