class Solution {
    public int myAtoi(String s) {
        int n=s.length();
        long res=0;
        int i=0;
        boolean isPositive=true;
        
        //skip whitespaces
        while (i<n && s.charAt(i)==' ')
            i++;

        if (i==n)
            return 0;

        //check sign
        if (s.charAt(i)=='-') {
            isPositive=false;
            i++;
        } else if (s.charAt(i)=='+') {
            isPositive=true;
            i++;
        } else if (!Character.isDigit(s.charAt(i)))
            return 0;

        //check zeroes
        while (i<n && s.charAt(i)=='0')
            i++;

        if (i==n || !Character.isDigit(s.charAt(i)))
            return 0;

        while (i<n && Character.isDigit(s.charAt(i))) {
            res=(res*10+(s.charAt(i)-'0'));
            i++;

            if (res>(long)Integer.MAX_VALUE)
                break;
        }

        if (!isPositive)
            res*=-1;

        if (res>(long)Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if (res<(long)Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int)res;
    }
}