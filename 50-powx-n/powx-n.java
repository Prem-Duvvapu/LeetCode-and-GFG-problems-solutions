class Solution {
    public double myPow(double x, int n) {
        if (x==1 || n==0)
            return 1.0;

        if (n<0)
        {
            n=-n;
            x=1/x;
        }

        double result=1.0;
        while (n!=0)
        {
            if ((n & 1)==1)//if n is odd i.e. if (n%2)==1
                result*=x;

            x*=x;
            n>>>=1;// performs the operation n=n/2
        }

        /*
        
>> Binary Right Shift
The left operand value is moved right by the number of bits specified by the right operand.

>>> Shift right zero fill
The left operand value is moved right by the number of bits specified by the right operand and shifted values are filled up with zeros.

        */

        return result;
        
    }
}