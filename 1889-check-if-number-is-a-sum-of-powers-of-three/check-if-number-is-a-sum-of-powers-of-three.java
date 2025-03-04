class Solution {
    public boolean checkPowersOfThree(int n) {
        int maxPowerOfThree=4782969; //3^14 since n<=10^7
        int curr=n;

        while (maxPowerOfThree > 0) {
            if (curr>=maxPowerOfThree)
                curr-=maxPowerOfThree;

            maxPowerOfThree/=3;

            if (curr==0)
                return true;
        }

        return false;
    }
}